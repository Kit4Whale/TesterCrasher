interface DataActionNavI {
    button_add?: boolean
}


const DataActionNav: React.FC<DataActionNavI> =   (props) => {
    
    return (
        <div className="action-navigation">
            {props.button_add ? <button className="buttonAdd">
                    Добавить 
                    <span className="material-icons buttonAdd__icon">
                        add_circle_outline
                    </span>
                </button> : null}
        </div>
    )
}

export default DataActionNav