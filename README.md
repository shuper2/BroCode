# BroCode

Repository for BroCode hackathon team's Code4Good projects.

## Directory structure:

```text
/doc        --- project-related documents, including non-technical ones.
/backlog    --- things to do. (this should be deprecated, better find a thirdparty service like a kanban provider)
/services   --- backend services
/ui         --- frontend
/deploy     --- scripts, config etc for running
/demo       --- materials for demostration
```

## Dev guide:

Backend services:

1. (Optional)install gradle 4.8+: [Link](https://gradle.org/install/)
2. `git clone` this repository to your local env.
3. `cd` into dir `services`.
4. (Optional)run `gradle`(if you've done step 1) or `gradlew`. Now gradle is fetch dependencies from Ali's maven central mirror.
5. import `services` as root project into your favorite IDE. There should be 4 subprojects. See this [link](/services) for detailed info.

Front services:
1. todo

## Build & Deploy guide:

todo

## Maintenance guide:

* For text doc please use markdown format, reference: https://guides.github.com/features/mastering-markdown/
* For minor commits like doc changes, please directly edit on the master branch and check in as soon as possible.
* For major changes like feature developments, please edit on a new branch and merge PR with proper documentation, the PR itself serves as doc.



