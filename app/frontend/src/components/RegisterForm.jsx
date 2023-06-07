import React, { useState, useCallback } from 'react';
import { createClient } from '../service/request';
import { Link } from "react-router-dom";

export default function RegisterForm() {
    const [sucessRequest, setSucessRequest] = useState(false);
    const [formsInfo, setFormsInfo] = useState({
        nome: "",
        telefone: "",
        dataNascimento: "",
        // dataInclusao: ,
        // dataAtualizacao: "",
    });

    const sendRegisterRequest = async (event) => {
        event.preventDefault();
        try {
            await createClient('/api/clientes', formsInfo);
            setSucessRequest(true);
        } catch (error) {
            console.log(error);
            setSucessRequest(false);
        }
    };

    const handleChange = useCallback(
        ({ target }) => {
          const auxValues = { ...formsInfo };
          auxValues[target.name] = target.value;
          setFormsInfo(auxValues);
        },
        [formsInfo],
    );
    
    return (
        <>
          <h2>Cadastrar novo beneficiário</h2>
          <form>
            <label htmlFor="nome">
              Nome
              <input
                type="text"
                name="nome"
                placeholder="Nome e sobrenome"
                value={ formsInfo.nome }
                onChange={ handleChange }
              />
            </label>
    
            <label htmlFor="telefone">
              Telefone
              <input
                type="text"
                name="telefone"
                placeholder="(xx)xxxx-xxxx"
                value={ formsInfo.telefone }
                onChange={ handleChange }
              />
            </label>
    
            <label htmlFor="dataNascimento">
              Data Nascimento
              <input
                type="date"
                name="dataNascimento"
                placeholder="xx/xx/xxxx"
                value={ formsInfo.dataNascimento }
                onChange={ handleChange }
              />
            </label>
    
            <button
              type="submit"
              onClick={ sendRegisterRequest }
            >
              CADASTRAR BENEFINICIÁRIO
            </button>
            <br />
            {
              sucessRequest && (
                <div>
                    <span>
                      Usuário cadastrado com sucesso!
                    </span>
                    <button
                        type='button'
                    >
                        <Link>
                            Voltar a opções
                        </Link>
                    </button>
                </div>
              )
            }
          </form>
        </>
      );
}