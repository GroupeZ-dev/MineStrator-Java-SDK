# MineStrator Java SDK (Java 21)

A lightweight **Java 21 SDK** for interacting with the **MineStrator API**, designed with a **clean, builder-like request API** and full support for **synchronous and asynchronous calls** using `CompletableFuture`.

This SDK focuses on **developer experience**:

* No manual JSON handling
* Strong typing everywhere
* One class = one request
* `.send()` and `.sendAsync()` directly on request objects

---

## ✨ Features

* ✅ Java 21 (records, HttpClient, CompletableFuture)
* ✅ Jackson-based JSON serialization / deserialization
* ✅ Strongly typed requests & responses
* ✅ Sync **and** async calls
* ✅ Clean DSL-style usage

---

## 📦 Installation

### Gradle

```gradle
dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
}
```

### Maven

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.1</version>
</dependency>
```

---

## ⚙️ Global Configuration

The SDK uses a global client configuration that must be initialized **once** at application startup.

```java
Minestrator.configure("YOUR_API_KEY_32_CHARS");
```

---

## 🚀 Create a Server (ZIP Deploy)

### Example

```java
CreateServerRequest request = new CreateServerRequest(
        3358, // ZIP Deploy Egg ID
        4,    // CPU cores
        8,    // RAM (GB)
        "ZIP Deploy Java 21",
        List.of(new RequiredField(
                "ZIP_URL",
                "http://dl.groupez.dev/minestrator/server.zip"
        )),
        "103536" // MyBox ID
);

MinestratorResponse<CreateServerData> response = request.send();

System.out.println("Server ID : " + response.api().data().id_server());
System.out.println("IP        : " + response.api().data().ip());
```

### Asynchronous Version

```java
request.sendAsync().thenAccept(response -> {
    System.out.println("Server created: " + response.api().data().id_server());
});
```

### JSON Sent Automatically

```json
{
  "id_egg": 3358,
  "cpu": 4,
  "ram": 8,
  "name": "ZIP Deploy Java 21",
  "required_fields": [
    {
      "key": "ZIP_URL",
      "value": "http://dl.minestrator.com/test/server.zip"
    }
  ]
}
```

---

## 🔌 Power Actions (Start / Stop / Restart / Kill)

Supported power actions:

* `START`
* `STOP`
* `RESTART`
* `KILL`

### Example: Restart a Server

```java
PowerActionRequest request = new PowerActionRequest(
        "381035",
        PowerAction.RESTART
);

MinestratorResponse<Void> response = request.send();

System.out.println("Status code : " + response.api().code());
```

### Asynchronous Version

```java
request.sendAsync().thenAccept(response -> {
    System.out.println("Power action sent successfully");
});
```

### JSON Sent Automatically

```json
{
  "poweraction": "restart"
}
```

---

## 🧱 Response Handling

All API responses are wrapped in a generic structure:

```java
MinestratorResponse<T>
```

Example for server creation:

```java
response.api().code();          // HTTP/API code
response.api().description();   // Description
response.api().endpoint();      // API endpoint
response.api().data();          // Typed data object
```

For endpoints without a `data` payload (delete, power actions), use:

```java
MinestratorResponse<Void>
```

---

## 🧩 Request Pattern

All requests follow the same pattern:

```java
new SomeRequest(...).send();
new SomeRequest(...).sendAsync();
```

Each request:

* Defines its endpoint
* Defines its path parameters
* Defines its request body (if needed)
* Defines its response type

---

## ✅ Supported Requests

* ✔ Create server (ZIP Deploy)
* ✔ Power actions (start / stop / restart / kill)
* ✔ Delete server

---

## 🛠️ Roadmap / Ideas

* Server status polling
* List servers & MyBoxes
* Error handling helpers
* Optional retry / timeout strategies
* Full MineStrator API coverage

---

## 📄 License

This project is provided as-is for MineStrator API integrations.
You are free to adapt it for personal or commercial use.
