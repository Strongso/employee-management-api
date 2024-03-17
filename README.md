# employee-management-api

This is an employee management api that handles a MySQL database.



## 🆕 Git & Github

### Branching
We will use the following branches:

* `feature/`: For developing new features.
* `fix/`: To fix bugs in the code. Often created associated to an issue.
* `hotfix/`: To fix critical bugs in the production.
* `release/`: To prepare a new release, typically used to do tasks such as last touches and revisions.
* `docs/`: Used to write, modify or correct documentation.
* `chore/`: Used to do tasks such as updating dependencies, refactoring, etc.

For example, `feature/new-feature` or `release/version-1.0.0`.

### Commit Messages

For commits we will be using the patterns from [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/).

We will commonly use the following types:
* `feat`: A new feature.
* `fix`: A bug fix.
* `docs`: Documentation only changes.
* `style`: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc).
* `refactor`: A code change that neither fixes a bug nor adds a feature.
* `test`: Adding missing tests or correcting existing tests.
* `chore`: Changes to the build process or auxiliary tools and libraries such as documentation or types generation.
* `ci`: Changes to our CI configuration files and scripts.


### (TO-REFINE) Pull Requests

These are the following patterns we will use for Pull Requests:

* We will use the `staging` branch as the base branch for all Pull Requests.
* We will not use the `main` branch for development.
* We will open a Pull Request from the `staging` branch into the `main` branch when we are ready to release a new version of the app.
* We will update the `incoming branch` with the latest changes from the `staging` branch before merging it (but you should update continously while working on the branch to avoid merge-conflicts).
* We will resolve any conflicts in the Pull Request before merging it, and we will not merge it until all checks have passed.
* We will tag the Pull Request with the appropriate labels, such as `feature`, `fix`, `documentation`, etc.
* We will take turns to review each other's Pull Requests, and we will not merge our own Pull Requests.
* We will keep merge commits. This is to keep a clear history of the changes made to the codebase.