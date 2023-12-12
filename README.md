# API Usuários

O endereço inclui o localhost:4567, pois a porta 4567 é a porta utilizada pela IDE Intellij.

Métodos HTTP

- [x] GET
```
└ listar() usuários
  └─ http://localhost:4567/usuarios 
└ buscar() usuário
  └─ http://localhost:4567/usuarios/:id
```
- [X] POST
```
└ inserir() usuário
   └─ http://localhost:4567/usuarios
```
- [X] PUT
```
└ alterar() usuário
   └─ http://localhost:4567/usuarios
```
- [X] DELETE
```
└ excluir() usuário
   └─ http://localhost:4567/usuarios/:id
```