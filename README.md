## User Role

## 1. User (User) privileges or Authorities.
- View profile
- Edit own profiles

##
## 2. User (Manager) privileges or Authorities.
- View profile
- Edit own profiles
- View other users
- Edit other users
- Access to restricted webpage.

## 3. Prefix-Roles:
- ROLE_USER (that defines the user).
- ROLE_ADMIN (that defines the manager).

## 4. Prefix-Authorities:
READ, WRITE, DELETE.

## 5. Authentication using: 
- userID and password.

## 6. Authorization:
- to check if the user is authorized in accessing the information.

## CONTROLLER:
- @RequestMapping("users") set in url end-point http://localhost:8080/users
- CRUD approach in creating(@PostMapping), reading(@GetMapping), updating(@PostMapping), delete(@DeleteMapping) of a user.
- @PostMapping method: (a createUser method that takes in parameter of requested body from the user in UserDetailsRequestModel (JSON format).
Approach: creating a restValue, new object from UserRestModel data type. Populating out using a class from springframework BeanUtils.copyProperties
which copies the source from (UserDetailsRequestModel) to the target (UserDto). Using the service class, and calls the createUser method to create userDto of the shared class and additionally
perform the override business logic that will pass to userEntity class in persisting it to the database.
Using the same approach, returning the value from the copied properties of the UserDto.)

## MODEL:
- UserDetailRequestModel should convert incoming JSON data request to a java object. (**Source of data.)
- UserRestModel should convert outgoing Java Object response to JSON format. (**target data)

## shared.dto (data transfer object) UserDto:
- holds the shared data of UserDetailRequestModel and UserRestModel. (**target data)

## SERVICE:
- UserService interface: contains methods that contains required parameters.
- UserServiceImp: contains the implementation business logic for the interface.

## UserEntity:
- used in persisting the annotated data types to the database. Fields as to the database columns requirements as set.

## UserRepository: 
- which takes the userEntity class and persist it to the database. extends CRUDRepository interface. Using Spring data JPA.
This helps in shortening development process, else will be required in creating a data access object class. And for each CRUD
operation, will require creating separate methods for each. Write database connections on the business logic, performing SQL Queries, close 
database connections. And as well in each Decoration requires creating READ and etc for the records. With CrudRepository, it's much easiler
with ready to use methods which requires the object to be passed in.