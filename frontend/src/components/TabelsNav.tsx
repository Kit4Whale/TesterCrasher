import { Link } from "react-router-dom"

const TabelsNav = () => {
    const checkUrl = (url: string) => {
        return url === window.location.pathname
    }

    return (
        <div className="homeTabs">
            <Link to="/clients" className={["homeTabs__button", checkUrl("/clients") ? "homeTabs__button_active": null]
                .filter(e => !!e)
                .join(' ')               
                }>
                    Клиенты
            </Link>
            <Link to="/groups" className={["homeTabs__button", checkUrl("/groups") ? "homeTabs__button_active": null]
                .filter(e => !!e)
                .join(' ')               
                }>
                    Группы
            </Link>
            <Link to="/employees" className={["homeTabs__button", checkUrl("/employees") ? "homeTabs__button_active": null]
                .filter(e => !!e)
                .join(' ')               
                }>
                    Сотрудники
            </Link>
        </div> 
    )
}

export default TabelsNav