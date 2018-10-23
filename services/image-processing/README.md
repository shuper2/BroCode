# Image processing module

## New BroCode repo gradle migration

* Use Spring to manage all services and properties, see ctx class `FindingImageApplication`
[link](./src/main/java/com/epam/hackathon/image/FindingImageApplication.java)

* Use `CaseRepository` to fetch cases which contain image path/url.

* Convert/Map aws `CompareFacesMatch` to domain object.

## Process flow:

todo