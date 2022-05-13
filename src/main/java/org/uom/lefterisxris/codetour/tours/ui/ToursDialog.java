package org.uom.lefterisxris.codetour.tours.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import org.uom.lefterisxris.codetour.tours.domain.Tour;
import org.uom.lefterisxris.codetour.tours.state.StateManager;

import javax.swing.*;
import java.util.List;

public class ToursDialog extends DialogWrapper {

   private Project project;
   private String tourName;

   public ToursDialog(@Nullable Project project) {
      super(project, false);
      this.project = project;
      setTitle("Pick a Tour!");
      init();
   }

   @Override
   protected @Nullable JComponent createCenterPanel() {
      final List<Tour> tours = new StateManager(project).getTours();

      final ComboBox<String> comboBox = new ComboBox<>();
      tours.stream().map(Tour::getTitle).forEach(comboBox::addItem);
      comboBox.addActionListener(e -> tourName = (String)comboBox.getSelectedItem());

      final JPanel panel = new JPanel();
      panel.add(comboBox);

      return panel;
   }

   public String getTourName() {
      return tourName;
   }
}