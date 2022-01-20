# CodeTour

MSc Thesis. University of Macedonia, Greece.

**Original Name**: CodeTrailer
> :exclamation: Renamed to CodeTour as a similar VSCode `GREAT` plugin already exist (https://github.com/microsoft/codetour), and thus this one would be compatible with it and would try to provide more enhanced experience.

<hr>

## :scroll: Thesis Info :mortar_board:

![alt text](code-tour-uom-logo-white-en.jpg)

### Thesis titile: `Code Reading Challenges & Best Practices`
Master Thesis, MSc Program: *Computer Science and Technology*, [University of Macedonia]()

#### Thesis Goals
 1. to find out, what makes Code reading so challenging, especially when there is no one for direct assistance, 
 2. to identify some Best Practices that may improve Code reading and understanding process,
 3. to provide a tool, which could be standing as a Virtual guide for a developer, providing navigation and demonstration of important code parts, as instructed/recorded by a Project member.

The whole Thesis (including research and development) is being managed on Github, and more information can be found on the repository: https://github.com/LefterisXris/CodeTour. The final results would be announced on the repo, so keep an eye on that, in case you are interested to check them.

### Management

The following projects have been created for managing the whole Thesis (including research and development):
- [Thesis Deliverables](https://github.com/LefterisXris/CodeTour/projects/3)
- [Research](https://github.com/LefterisXris/CodeTour/projects/2)
- [Plugin - Development](https://github.com/LefterisXris/CodeTour/projects/1)

### 📢 Participate on the research, via the Thesis survey (SurveySparrow): [Code Reading Challenges & Best Practices](https://codetour.surveysparrow.com/s/code-reading-challenges--best-practices/tt-080a698c44)

<hr>

## :wrench: Plugin Info :electric_plug:

![Build](https://github.com/LefterisXris/CodeTrailer/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
👉 Vision: A tool that stands as a Virtual guide for a new member able to navigate him throughout the code, demonstrating important code parts or features, based on the instructions (configuration) that an experienced project member has already provided. Think of it, like a tutorial-wizard that presents the code with extra info, comments, images and maybe voice as well. Adding instructions is as simple as adding a new breakpoint, and the tool is able to auto-adjust, so that on code changes, the instructions (steps) remain valid. Instructions can also be under version control, for maintainability.
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "CodeTrailer"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/LefterisXris/CodeTrailer/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


## Conventions

### Type of Commits
- `feat`: A new feature adding to a particular application
- `fix`: A bug fix
- `style`: Feature and updates related to styling
- `refactor`: Refactoring a specific section of the codebase
- `test`: Everything related to testing
- `docs`: Everything related to documentation
- `chore`: Regular code maintenance

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
