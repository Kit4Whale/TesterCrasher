import React from 'react'  
import DataActionNav from '../../components/DataActionNav/DataActionNav'
import TabelsNav from '../../components/TabelsNav'
import TopNavbar from '../../components/Topnavbar'
import EmloyeesList from './EmloyeesList'

const EmployeesPage = () => { 
    return (
        <div className='employeesPage'>
            <TopNavbar/>
            <TabelsNav/>
            <header>Empleeyes</header>
            <div className="employeesPage__content">
                <DataActionNav button_add={true}/>
                <EmloyeesList />
            </div>
        </div>
    )
}

export default EmployeesPage