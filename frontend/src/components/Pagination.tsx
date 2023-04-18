import { useState } from "react"

interface PaginationI {
    pages_count: number
    active_pag: number 
    pag_action: (pag: number) => void
}

const Pagination:React.FC<PaginationI> = (props) => {

    const [active_pag, setActive_pag] = useState(props.active_pag)
    const [pages_count] = useState(props.pages_count)

    const handlerPagClick = (num: number, action: (number: number) => void) => {
        if(num > 0 && num <= pages_count) {
            action(num)
            setActive_pag(num)
        }
    }

    const isFirst = (num: number) => {
        return num === 1 ? true : false
    }

    const isLast = (num:number) => {
        return num === pages_count ? true : false 
    }

    const isActive = (num:number) => {
        return num === active_pag ? true : false
    }

    const isPrevNeighbour = (num:number) => {
        return active_pag - 1 === num ? true : false 
    }

    const isNextNeighbour = (num:number) => {
        return active_pag + 1 === num ? true : false
    }

    const validation = [isFirst, isLast, isActive, isPrevNeighbour, isNextNeighbour]
    
    return (
        <div className='clientsPage__pagination pagination'>
            <span className={["material-icons pagination__arrow pagination__arrow_left", active_pag <= 1 ? "pagination__arrow_deactive" : null].join(" ")}
                onClick={() => handlerPagClick(active_pag - 1, props.pag_action)}>
                arrow_back_ios
            </span>
            {pages_count 
                ? Array.from({ length: pages_count }, (_ ,i) => i + 1).filter((array_number, id) => {return validation.some((check, check_id) => check(array_number))} )
                .map((number, id) => {return ( 
                    <>
                        {isPrevNeighbour(number) && !isFirst(number) && !isFirst(number - 1)? <span>...</span> : null}
                        <span onClick={() => handlerPagClick(number, props.pag_action)} className={
                            ["pagination__page", active_pag === number ? "pagination__page_active" : null ]
                            .join(" ")}>
                                {number}
                        </span>
                        {isNextNeighbour(number) && !isLast(number) && !isLast(number + 1) ? <span>...</span> : null}
                    </>
                    
            )}) : <span>Нет записей</span> }
            <span className={["material-icons pagination__arrow pagination__arrow_right", active_pag >= pages_count ? "pagination__arrow_deactive" : null].join(" ")}
                    onClick={() => handlerPagClick(active_pag + 1, props.pag_action)}>
                arrow_forward_ios
            </span>
        </div>
    )
}

export default Pagination