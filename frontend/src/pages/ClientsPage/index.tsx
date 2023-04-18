import React, { useEffect } from 'react'  
import { useNavigate } from 'react-router'
import DataActionNav from '../../components/DataActionNav/DataActionNav'
import TabelsNav from '../../components/TabelsNav'
import TopNavbar from '../../components/Topnavbar'
import { useAppSelector } from '../../store/redux-hooks'
import ClientsTable from './ClientsTabel'


const ClientsPage = () => { 
    const access = useAppSelector(state => state.users.access)
    const navigate = useNavigate()

    useEffect(() => {
        if (!access) {
            navigate("/auth")
        }
    }, [access, navigate])

    return (
        <div className='clientsPage'>
            <TopNavbar/>
            <TabelsNav/>
            <div className="clientsPage__content">
                <DataActionNav button_add={true}/>
                <ClientsTable />
            </div>
        </div>
    )
}

export default ClientsPage