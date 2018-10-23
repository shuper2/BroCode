## Development todo list

### Feature implementation

* City/Region database, so that coordination can be related.
* Query lost case advertisement by preference. An algorithm must be implemented to show each end user the images with higher priority.
* Image processing, to implement interface `ImageMatchingApi` under module `image-processing`.
* Image processing task fetching. It's quadratically complex to compare each 2 lost/finding case combination. There must be an algorithm to reduce this complexity.

### Process improvement

* Deployment orchestration. Scripts or tools need to be used to achieve automatic deployment, so that a demostration can be made simple.