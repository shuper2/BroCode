## Development todo list

### Feature implementation

Mandatory:

* Image processing, to implement interface `ImageMatchingApi` under module `image-processing`.
* Image file uploading. Since we may use local file system as storage, file loading mechanism must be development between UI and Web service.
* Implementation of `CaseRepository`. Choose whatever underlying db.
* Implementation of `CaseRepository`. Choose whatever underlying db.

Mockable & Optional:

* Image processing task fetching. It's quadratically complex to compare each 2 lost/finding case combination. There must be an algorithm to reduce this complexity.
* City/Region database, so that coordination can be related.
* Query lost case advertisement by preference. An algorithm must be implemented to show each end user the images with higher priority.

### Process advancement

Mandatory:

* Deployment orchestration. Scripts or tools need to be used to achieve automatic deployment, so that a demostration can be made simple.

Optional:

* Task management. Should a Kanban service be found, we don't need to commit on this file.
* Documentation. Please fill the doc linked on the main readme, if you know how. This could surely make our project more understandable.