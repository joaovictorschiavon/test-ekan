import { Link } from "react-router-dom"
import { useState, useCallback } from 'react';
import { deleteClient, returnAllClients, getClient } from '../service/request';


export default function Options() {
    const [id, setId] = useState({
        idDel: '',
        idSearch: '',
    });
    

    const handleChange = useCallback(
        ({ target }) => {
          const auxValues = { ...id };
          auxValues[target.name] = target.value;
          setId(auxValues);
        },
        [id],
    );

    const handleSearchClick = async (event) => {
        event.preventDefault();
        try {
            await returnAllClients('/api/clientes');
            // setSucessRequest(true);
        } catch (error) {
            console.log(error);
            // setSucessRequest(false);
        }
    };

    const fetchDocuments = async (event) => {
        event.preventDefault();
        try {
            await getClient(`/api/clientes/${id.idSearch}`);
            // setSucessRequest(true);
        } catch (error) {
            console.log(error);
            // setSucessRequest(false);
        }
    };

    const deleteClick = async (event) => {
        event.preventDefault();
        try {
            await deleteClient(`/api/clientes/${id.idDel}`);
            // setSucessRequest(true);
        } catch (error) {
            console.log(error);
            // setSucessRequest(false);
        }
    };


    return (
        <>
            <h2>Gerenciamento de beneficiários</h2>
            <div>
                <button
                    type='button'
                >
                    <Link to="/register">
                        Cadastrar beneficiário
                    </Link>
                </button>
                <button
                    type='button'
                >
                    <Link to="/update">
                        Atualizar beneficiário
                    </Link>
                </button>
            </div>
            <div>
                <label htmlFor="idDel">
                    Id para deletar beneficiário
                    <input
                        type="number"
                        name="idDel"
                        placeholder="númedo de identificação"
                        value={ id.idDel }
                        onChange={ handleChange }
                    />
                </label>
                <button
                    type='button'
                    onClick={ deleteClick }
                >
                    Deletar Beneficiário
                </button>
            </div>
            <div>
                <button
                    type='button'
                    onClick={ handleSearchClick }
                >
                    Buscar todos beneficiários
                </button>
            </div>
            <div>
                {

                }
            </div>
            <div>
                <label htmlFor="id2">
                    Id de beneficiário para buscar documentos
                    <input
                        type="number"
                        name="idSearch"
                        placeholder="númedo de identificação"
                        value={ id.idSearch }
                        onChange={ handleChange }
                    />
                </label>
                <button
                    type='button'
                    onClick={ fetchDocuments }
                >
                    Buscar documentos do beneficiário
                </button>
            </div>
            <div>
                {

                }
            </div>
        </>
    );
}