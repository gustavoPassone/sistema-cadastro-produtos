# Sistema de Cadastro de Produtos 📦

Projeto prático em **Java** desenvolvido para exercitar os conceitos fundamentais de **Programação Orientada a Objetos (POO)**, com foco em **encapsulamento**, **atributos privados**, **métodos getters/setters**, uso de **`this`** e validação de regras de negócio.

---

## 🎯 Objetivos do Projeto

- Implementar uma classe de domínio segura e encapsulada (`Produto`).
- Impedir atribuições diretas de estados inconsistentes aos objetos através de atributos privados.
- Garantir a integridade dos dados por meio de validações dentro dos métodos modificadores (`set`).
- Realizar cálculos de negócio (valor total em estoque).
- Validar as restrições de acesso e compilação do Java na classe de teste (`ProdutoTest01`).

---

## 🧱 Conceitos de POO Aplicados

- **Encapsulamento:** Os dados internos de cada produto estão protegidos contra modificações externas descontroladas.
- **Modificadores de Acesso (`private` e `public`):**
  - Atributos definidos como `private`, acessíveis exclusivamente dentro da classe `Produto`.
  - Métodos `public` atuando como a interface de comunicação do objeto com o mundo exterior.
- **Palavra-chave `this`:** Utilizada para referenciar a instância corrente do objeto e diferenciar os atributos da classe dos parâmetros recebidos nos métodos.
- **Integridade e Validação:** Os métodos `set` interceptam valores inválidos antes de aplicá-los ao estado do objeto.

---

## 📂 Estrutura de Diretórios

```text
cadastro-produtos/
├── src/
│   ├── dominio/
│   │   └── Produto.java          # Classe de domínio com atributos privados, getters, setters e lógica de cálculo
│   └── test/
│       └── ProdutoTest01.java    # Classe executável com casos de teste, validações e saídas formatadas
└── README.md
```

---

## 📋 Regras de Negócio Implementadas

| Atributo | Tipo | Regra de Validação |
| :--- | :--- | :--- |
| `nome` | `String` | Não pode ser `null`, vazio ou composto apenas por espaços em branco (`isBlank()`). |
| `preco` | `double` | Não pode ser negativo. |
| `quantidade` | `int` | Não pode ser negativa. |

> **Nota:** Quando um valor inválido é informado no `set`, o sistema exibe uma mensagem de erro no console e **não altera** o valor do atributo, preservando o valor anterior.

### Métodos Especiais

- **`calcularValorEstoque()`**: Retorna o produto entre `preco` e `quantidade` ($\text{preço} \times \text{quantidade}$).
- **`adicionarEstoque(int quantidade)`** *(Desafio Extra)*: Valida se a quantidade a ser adicionada é positiva ($> 0$) e incrementa o estoque atual.

---

## 🔒 Teste de Encapsulamento

Se tentarmos acessar diretamente um atributo privado fora da sua classe:

```java
produto01.preco = 500;
```

O compilador Java acusará o seguinte erro:

```text
error: preco has private access in Produto
        produto01.preco = 500;
                 ^
```

**Por que isso acontece?**  
Porque atributos marcados como `private` só podem ser lidos ou modificados pelos métodos da própria classe `Produto`. Para alterar ou consultar o preço, é obrigatório utilizar `setPreco(...)` e `getPreco()`.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java JDK 17** ou superior instalado.

### 1. Pelo Terminal (PowerShell / Bash)

No diretório raiz do projeto:

```bash
# Compilar os fontes para a pasta 'out'
javac -encoding UTF-8 -d out src/dominio/Produto.java src/test/ProdutoTest01.java

# Executar a classe principal
java -cp out test.ProdutoTest01
```

### 2. Pelo IntelliJ IDEA
1. Abra o diretório `cadastro-produtos` no IntelliJ IDEA.
2. Navegue até `src/test/ProdutoTest01.java`.
3. Clique com o botão direito no arquivo ou no método `main` e selecione **Run 'ProdutoTest01.main()'** (ou `Shift + F10`).

---

## 💻 Saída Esperada no Console

```text
========== PRODUTO 01 ==========
Nome: Teclado
Preço: R$ 150.0
Quantidade: 5
Valor do estoque: R$ 750.0

========== PRODUTO 02 ==========
Nome: Mouse
Preço: R$ 80.0
Quantidade: 10
Valor do estoque: R$ 800.0

========== TESTANDO VALIDACOES ==========
Erro: o preço não pode ser negativo.
Erro: a quantidade não pode ser negativa.
Erro: o nome do produto não pode ser vazio.
Preço do Teclado após tentativa inválida: R$ 150.0
Quantidade do Mouse após tentativa inválida: 10

========== DESAFIO EXTRA: ADICIONAR ESTOQUE ==========
Nova quantidade de Teclado: 8
Novo valor do estoque: R$ 1200.0
```
