import React from 'react'  
import TabelsNav from '../components/TabelsNav'
import TopNavbar from '../components/Topnavbar'

const GroupsPage = () => { 
    return (
        <div className='groupsPage'>
            <TopNavbar/>
            <TabelsNav/>
            <header>Groups</header>
        </div>
    )
}

export default GroupsPage