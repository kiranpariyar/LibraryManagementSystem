package librarymntsys

class Member {

    String firstName
    String lastName
    String address
    String phone

    static constraints = {
        firstName(blank: false)
        address(blank: false)
        phone(blank: false)
    }
}
