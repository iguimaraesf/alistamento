# language: pt
Funcionalidade: Determinar a situação de um membro
  Ao se cadastrar, o membro fica na situação NAO_CONFIRMADO porque o link de confirmação de e-mail é enviado para ele.
  Depois que o link de confirmação é ativado, ele passa para a situação LIBERADO.
  Ele fica RESTRITO quando infringir as regras do aplicativo. Por exemplo, quando faz um anúncio de venda.
  Contexto: A pessoa já está cadastrada no sistema
  Esquema do Cenário: Diferentes estados da conta do membro
    E o código do membro é <codigo>
    E a data final de restrição é <dataFimRestricao>
    E a data da confirmação é <dataConfirmacao>
    Então a situação do membro é <situacao>
    Exemplos:
      | codigo         | dataFimRestricao | dataConfirmacao | situacao         |
      | "inexistente"  | ""               | ""              | "NAO_CONFIRMADO" |
      | "existente"    | ""               | ""              | "NAO_CONFIRMADO" |
      | "existente"    | ""               | "passado"       | "LIBERADO"       |
      | "existente"    | "passado"        | "passado"       | "LIBERADO"       |
      | "existente"    | "passado"        | ""              | "NAO_CONFIRMADO" |
      | "existente"    | "futuro"         | "passado"       | "RESTRITO"       |
      | "existente"    | "futuro"         | ""              | "NAO_CONFIRMADO" |
      | "existente"    | "passado"        | "futuro"        | "LIBERADO"       |
