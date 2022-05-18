package org.uom.lefterisxris.codetour.tours.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.uom.lefterisxris.codetour.tours.domain.Step;
import org.uom.lefterisxris.codetour.tours.domain.Tour;
import org.uom.lefterisxris.codetour.tours.state.StateManager;
import org.uom.lefterisxris.codetour.tours.state.TourUpdateNotifier;
import org.uom.lefterisxris.codetour.tours.ui.TourSelectionDialogWrapper;

import java.util.Optional;

import static java.util.Objects.isNull;

public class TourStepGeneratorAction extends AnAction {

   private static final Logger LOG = Logger.getInstance(TourStepGeneratorAction.class);

   @Override
   public void actionPerformed(@NotNull AnActionEvent e) {
      final Project project = e.getProject();
      if (isNull(project) || isNull(project.getBasePath()))
         return;

      // TODO: Get the current location and add it on active Tour
      //  check e.getData(CommonDataKeys.EDITOR).getGutter()
      //  NavigationGutterIconRenderer
      //  PsiTreeUtil.getParentOfType(e.getData(CommonDataKeys.PSI_FILE).findElementAt(editor.getCaretModel().getOffset()), com.intellij.psi.PsiMethod.class);
      //  final Editor editor = e.getData(CommonDataKeys.EDITOR);
      //  final EditorGutter editorGutter = e.getData(EditorGutter.KEY);

      final Object lineObj = e.getDataContext().getData("EditorGutter.LOGICAL_LINE_AT_CURSOR");
      final int line = lineObj != null ? Integer.parseInt(lineObj.toString()) : 1;

      final VirtualFile virtualFile = e.getDataContext().getData(CommonDataKeys.VIRTUAL_FILE);
      if (virtualFile == null)
         return;

      final StateManager stateManager = new StateManager(project);

      // If no activeTour is present, prompt to select one
      if (StateManager.getActiveTour().isEmpty()) {
         final TourSelectionDialogWrapper dialog = new TourSelectionDialogWrapper(project,
               "Please Select the Tour to add the Step to");
         if (dialog.showAndGet()) {
            final Optional<Tour> selected = dialog.getSelected();
            selected.ifPresent(tour -> StateManager.setActiveTour(tour));
         }
      }

      final Optional<Tour> activeTour = StateManager.getActiveTour();
      if (activeTour.isPresent()) {
         final Step step = generateStep(virtualFile, line);
         activeTour.get().getSteps().add(step);
         stateManager.updateTour(activeTour.get());

         // Notify UI to re-render
         project.getMessageBus().syncPublisher(TourUpdateNotifier.TOPIC).tourUpdated(activeTour.get());
      }

   }

   private Step generateStep(VirtualFile virtualFile, int line) {
      final String title = String.format("%s:%s", virtualFile.getName(), line);
      LOG.info("Generating Step: " + title);
      return Step.builder()
            .title(title)
            .description("Simple Navigation to " + title)
            .file(virtualFile.getName())
            .line(line)
            .build();
   }

}