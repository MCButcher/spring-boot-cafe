# spring-boot-cafe

## stage-01-spec

### Specifications
Implement the entities for the **Menu**.  
A suitable implementation for **Category** is already done.  

```
    class Category
        - id : Long
        - name : String
        
    class Menu
        - id : Long
        - item _ String
        - price : Double
        - category : Category
```

### Tasks
- Change the *application.properties* to *application.yml* and configure the port to **8888** and the service context to **/api**
- Start the service and check, if **Category** endpoints are available
- Implement the model, service, controller for the menu according to the **Category**
- Implement an additional functionality **getByCategory** to the service and controller for the **Menu**
- Import the prepared request collection for postman (see directory *postman*) and adapt it for the **Menu** endpoints

### Goals
- Service Endpoints are available and return a 200 and a response body
