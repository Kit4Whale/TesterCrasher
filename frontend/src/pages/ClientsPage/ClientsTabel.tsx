import { Table } from "react-bootstrap"
import Pagination from "../../components/Pagination"

const ClientsTable = () => {

    const clientPaginationAction = (pag:number) => {
        console.log("Клиент страница" + pag)
    }

    return (
        <>
            <Table responsive>
                <thead>
                    <tr>
                        <th>ФИО</th>
                        {Array.from({ length: 12 }).map((_, index) => (
                            <th key={index}>Table heading</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>1</td>
                    {Array.from({ length: 12 }).map((_, index) => (
                        <td key={index}>Table cell {index}</td>
                    ))}
                    </tr>
                    <tr>
                    <td>2</td>
                    {Array.from({ length: 12 }).map((_, index) => (
                        <td key={index}>Table cell {index}</td>
                    ))}
                    </tr>
                    <tr>
                    <td>3</td>
                    {Array.from({ length: 12 }).map((_, index) => (
                        <td key={index}>Table cell {index}</td>
                    ))}
                    </tr>
                </tbody>
            </Table>
            <Pagination pag_action={clientPaginationAction} pages_count={11} active_pag={2}/>
        </>
    )
}

export default ClientsTable