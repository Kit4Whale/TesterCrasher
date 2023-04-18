import { useState } from 'react'
import { NavDropdown } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import { getLogout } from '../store/reducers/usersActions'
import { useAppDispatch, useAppSelector } from '../store/redux-hooks'


const TopNavbar = () => {
    const name = useAppSelector(state => state.users.name)
    const access = useAppSelector(state => state.users.access) 
    const dispatch = useAppDispatch();
    const [languages] = useState<Array<string>>(["RUS", "ENG", "DET", "ITA"])
    const [selectLanguage, setSelectLanguage] = useState(languages[0])

    const setLanguageHandler = (language: string) => {
        setSelectLanguage(language)
    }

    const logoutHandler = () => {
        dispatch(getLogout())
    }

    return (
        <div className='topNavbar'>
            <Link to="/" className='topNavbar__mainLink'>Address BookApp</Link>
            {false ? <><span>Name: {name}</span>
            <span>Access: {access}</span></> : null}
            <div className="toolBar">
                <div className="toolBar__personal personal">
                    <span className='personal__icon'
                        style={{"backgroundImage": "url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-cyZ6CD08umGcY76yjpEDjTNjigG9MEXMjw&usqp=CAU)"}}>
                    </span>
                    <span className='personal__name'>{name}{access === "FullAccess" ? " (админ)" : null}</span>
                    <span className='personal__logout' onClick={logoutHandler}>Выйти</span>
                </div>
                <div className="toolBar__geo geo">
                <span className="material-icons">
                    language
                </span>
                <span className="geo__name">
                {selectLanguage}
                </span>
                <NavDropdown title=" " id="basic-nav-dropdown" className='geo__menu'>
                    { languages.map((item, key) => {
                        if(item !== selectLanguage) {
                            return <NavDropdown.Item 
                                href={"#action/3.1" + key} 
                                key={key}
                                onClick={()=> setLanguageHandler(item)}>{item}</NavDropdown.Item>
                        } else {
                           return null
                        }
                        })
                    }
                    <NavDropdown.Divider />
                    <NavDropdown.Item href={"#action/3.1"}>
                        {selectLanguage}
                    </NavDropdown.Item>
                </NavDropdown>
                </div>
            </div>
        </div>
    )
}

export default TopNavbar