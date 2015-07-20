package librarymntsys

class User {

    // time stamps: automatically populated by GORM
    Date dateCreated
    Date lastUpdated

    String firstName
    String lastName
    String username
    String password

    // constraints
    static constraints = {
        firstName blank:false;
        lastName  blank:false;
        username  blank:false, size:5..15, matches:/[\S]+/, unique:true
        password  blank:false, size:5..15, matches:/[\S]+/, password:true
    }

}
