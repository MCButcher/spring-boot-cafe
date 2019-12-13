# spring-boot-cafe

## stage-02-spec

### Specifications
Implement the error handling for the **Menu**.  
A suitable implementation for **Category** is already done.  

### Tasks
- Add an **UnknownCategoryException** which will be thrown, when the name of the category is ``null`` in **getByCategory** inside the **MenuService**
- Add a method for the new exception to the **ErrorHandler** and return the http status 422
- Add a log message when the exception is thrown

### Goals
- When calling the endpoinf *GET /api/menu/category* where the attribute **name** is missing in the body, an api error with the defined http status is returned
- A log message in the console should be visible

### Next Stage
[stage-03](https://github.com/ns-cegeka/spring-boot-cafe/tree/stage-03)