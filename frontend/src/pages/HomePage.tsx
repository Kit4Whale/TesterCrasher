import React, { useEffect } from "react" 
import { useNavigate } from "react-router-dom"
import TabelsNav from "../components/TabelsNav"
import TopNavbar from "./../components/Topnavbar"
import { useAppSelector } from "./../store/redux-hooks"

const HomePage = () => {

    const access = useAppSelector(state => state.users.access)
    const navigate = useNavigate()

    useEffect(() => {
        if (!access) {
            navigate("/auth")
        }
    }, [access, navigate])

    if(access) {
        return (
            <div className="homePage">
                <TopNavbar/>
                <TabelsNav/>
                <div className="homePage__welcomeText welcomeText">
                    <header className="welcomeText__header">Добро пожаловать в Address BookApp!</header>
                    <p className="welcomeText__text">
                        Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. 
                        Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.
                    </p>
                </div>
            </div>
        )
    } else {
        return <></>
    }
}

export default HomePage