# Api specs

## UI -> Web service API

#### Publish lost:

Endpoint: `/lost/publish`, POST

Request:
```json
{
    "user-id": "string",
    "lost-time": "string",
    "country": "string",
    "city": "string",
    "age": "number",
    "gender": "string",
    "image-url": "string"
}
```
Response:
```json
{
    "lost-id": "number"
}
```

#### Query all lost:

Endpoint: `/lost/query`, POST

Request:
```json
{
    "user-id": "string",
    "latitude": "number",
    "longitude": "number"
}
```
Response:
```json
[
    {
        "lost-id":"number",
        "user-id": "string",
        "lost-time": "string",
        "country": "string",
        "city": "string",
        "age": "number",
        "gender": "string",
        "image-url": "string",
        "highest-probability": "number"
    },
    ...
]
```

#### Query user published lost:

Endpoint: `/lost/query-my`, POST

Request:
```json
{
    "user-id": "string",
    "page-num": "number"
}
```
Response:
```json
[
    {
        "lost-id":"number",
        "user-id": "string",
        "lost-time": "string",
        "country": "string",
        "city": "string",
        "age": "number",
        "gender": "string",
        "image-url": "string",
        "highest-probability": "number"
    },
    ...
]
```

#### Report finding:

Endpoint: `/finding/report` POST

Request:
```json
{
    "user-id": "string",
    "capture-time": "string",
    "latitude": "number",
    "longitude": "number",
    "image-url": "string",
    "intended-lost-id":"number"
}
```
Response:
```json
{
    "finding-id": "number"
}
```

#### Query lost match detail:

Endpoint: `/finding/match-detail` POST

Request:
```json
{
    "user-id": "string",
    "lost-id": "number"
}
```

Response:
```json
[
    {
        "probability": "number",
        "finding-id": "number",
        "capture-time": "number",
        "latitude": "number",
        "longitude": "number",
        "image-url": "string"
    },
    ...
]
```

#### Confirm matching:

Endpoint: `/finding/confirm` POST

Request:
```json
{
    "user-id": "string",
    "lost-id": "number",
    "finding-id": "number"
}
```