package librarymntsys

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MemberController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Member.list(params), model:[memberCount: Member.count()]
    }

    def show(Member member) {
        respond member
    }

    def create() {
        respond new Member(params)
    }

    @Transactional
    def save(Member member) {
        if (member == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (member.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond member.errors, view:'create'
            return
        }

        member.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'member.label', default: 'Member'), member.id])
                redirect member
            }
            '*' { respond member, [status: CREATED] }
        }
    }

    def edit(Member member) {
        respond member
    }

    @Transactional
    def update(Member member) {
        if (member == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (member.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond member.errors, view:'edit'
            return
        }

        member.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'member.label', default: 'Member'), member.id])
                redirect member
            }
            '*'{ respond member, [status: OK] }
        }
    }

    @Transactional
    def delete(Member member) {

        if (member == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        member.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'member.label', default: 'Member'), member.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'member.label', default: 'Member'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
