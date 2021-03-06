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

## Document:

* [Project & Architecture](./doc)
* [User Interface](./ui)
* [Backend Services](./services)
    * [Image processing](./services/image-processing)
* [Internal API specs](./doc/API.md)
* etc.. todo

## Dev & Build guide:

Backend services:

1. install maven 3.2+: [Link](https://maven.apache.org/)
2. `git clone` this repository to your local env.
3. `cd` into dir `services`.
4. (Optional)run `mvn compile` to fetch dependencies from Ali's maven central mirror.
5. import `services` as root dir into your favorite IDE as a maven project.
6. web service will be started by either:
    * run main class `FindingWebApplication` in IDE
    * run cmd: `mvn install` under `services` dir to package module jars, then run cmd `mvn spring-boot:run` under `web` dir.

Frontend:
1. once web service is started, home page can be accessed at `localhost:8080`, any file changes under `ui` dir, will be reflected by refresh the browser(cache-disabled), no need to restart the web service.


## Maintenance guide:

* For text doc please use markdown format, reference: https://guides.github.com/features/mastering-markdown/
* For minor commits like doc changes, please directly edit on the master branch and check in as soon as possible.
* For major changes like feature developments, please edit on a new branch and merge PR with proper documentation, the PR itself serves as doc.



