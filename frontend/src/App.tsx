import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Loader from './components/Loader';
import AuthPage from './pages/AuthPage';
import HomePage from './pages/HomePage';
import EmployeesPage from './pages/EmployeesPage';
import GroupsPage from './pages/GroupsPage';
import ClientsPage from './pages/ClientsPage';


function App() {

  const router = createBrowserRouter([
    {
      path: "/",
      element: <HomePage />,
      children: [],
    },
    {
      path: "auth",
      element: <AuthPage />,
    },
    {
      path: "clients",
      element: <ClientsPage/>,
    },
    {
      path: "groups",
      element: <GroupsPage />,
    },
    {
      path: "employees",
      element: <EmployeesPage />,
    },
  ]);

  return (
    <RouterProvider
      router={router}
      fallbackElement={<Loader />}
    />
  );
}

export default App;
