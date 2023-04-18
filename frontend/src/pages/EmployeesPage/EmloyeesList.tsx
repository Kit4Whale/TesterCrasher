import { useState } from "react"
import Pagination from "../../components/Pagination"

const EmloyeesList = () => {
    const [employees] = useState<Array<any>>([
        {
            name: "Борисова Екатерина Александровна",
            address: "Адрес: ул. Верхняя Масловка, 54, Москва",
            email: "Email: Borisova@gmail.com",
            phone: "Телефон: +7(800) 000 00 00",
            group: "1",
        },
        {
            name: "Борисова Екатерина Александровна",
            address: "Адрес: ул. Верхняя Масловка, 54, Москва",
            email: "Email: Borisova@gmail.com",
            phone: "Телефон: +7(800) 000 00 00",
            group: "1",
        },
        {
            name: "Борисова Екатерина Александровна",
            address: "Адрес: ул. Верхняя Масловка, 54, Москва",
            email: "Email: Borisova@gmail.com",
            phone: "Телефон: +7(800) 000 00 00",
            group: "1",
        },
        {
            name: "Борисова Екатерина Александровна",
            address: "Адрес: ул. Верхняя Масловка, 54, Москва",
            email: "Email: Borisova@gmail.com",
            phone: "Телефон: +7(800) 000 00 00",
            group: "1",
        },
        {
            name: "Борисова Екатерина Александровна",
            address: "Адрес: ул. Верхняя Масловка, 54, Москва",
            email: "Email: Borisova@gmail.com",
            phone: "Телефон: +7(800) 000 00 00",
            group: "1",
        },
        {
            name: "Борисова Екатерина Александровна",
            address: "Адрес: ул. Верхняя Масловка, 54, Москва",
            email: "Email: Borisova@gmail.com",
            phone: "Телефон: +7(800) 000 00 00",
            group: "1",
        }
    ])

    const employeePaginationAction = (pag:number) => {
        console.log("Сотрудники страница" + pag)
    }

    return (
            <>
                <div className='employeesPage__employeeList employeeList'>
                    {
                        employees.map((employee, key) => {
                            return (
                                <div className='card' key={key}>
                                    <span className='card__name'>{employee.name}</span>
                                    <span className='card__address'>{employee.address}</span>
                                    <span className='card__email'>{employee.email}</span>
                                    <span className='card__phone'>{employee.phone}</span>
                                    <span className='card__group'>{employee.group}</span>
                                    <div className="card__buttons">
                                        <span className="material-icons card__button card__button_edit">
                                            border_color
                                        </span>
                                        <span className="material-icons card__button card__button_delete">
                                            delete_outline
                                        </span>
                                    </div>
                                </div>
                            )
                        })
                    }
                </div>
                <div className="employeesPage__pagination">
                    <Pagination  pag_action={employeePaginationAction} pages_count={3} active_pag={1}/>
                </div>
            </>
    )
}

export default EmloyeesList