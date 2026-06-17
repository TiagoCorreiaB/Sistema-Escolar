# Sistema Escolar

Este projeto é uma aplicação de gerenciamento escolar desenvolvida em Java, que utiliza de forma ampla os conceitos da Programação Orientada a Objetos (POO), tais como Herança, Polimorfismo, Abstração, Encapsulamento e Composição.

---

## Arquitetura e Relacionamentos

### 1. Inversão de Controle e Injeção de Dependência
Na classe `Programa`, que é o ponto de entrada do sistema, as instâncias das listas de dados (`List<Aluno>`, `List<Funcionario>`, `List<Professor>`), das `Materia`s e do `Scanner` são inicializadas. 
Em vez das classes gerenciadoras (`GerenciadorAluno`, etc.) ou a classe `Menu` criarem o `Scanner` ou instaciarem os repositórios em seus construtores, elas **recebem** esses objetos por parâmetro em seus construtores (Injeção de Dependência). Isso é a **Inversão de Controle**, onde o fluxo tradicional de controle (uma classe criando suas próprias dependências) é invertido, delegando a responsabilidade de criação para a classe `Programa`.

### 2. Princípio de Inversão de Dependência
A classe `Menu` depende de módulos de baixo nível para realizar as operações de CRUD. Porém, ao invés de acoplar o `Menu` diretamente às classes concretas como `GerenciadorAluno` ou `GerenciadorProfessor`, a classe `Menu` declara como seus atributos variáveis do tipo `Gerenciador` (que é uma **Interface**).
**A lógica por trás disso:** "Programe para uma interface, não para uma implementação". O `Menu` sabe que todo gerenciador implementa o contrato `cadastrar`, `visualizar`, `alterar` e `excluir`. Ele não precisa saber os detalhes internos de como um `Aluno` ou um `Professor` é cadastrado, apenas chama o método definido pela interface. Isso facilita adicionar novos tipos de gerenciadores no futuro sem alterar o código do `Menu`.

### 3. Herança e Abstração
Foi criada uma classe abstrata `Pessoa` que não pode ser instanciada diretamente. Ela serve como modelo para classes filhas (`Aluno`, `Funcionario`), concentrando os atributos comuns (nome, idade, cpf, email). A herança continua com a classe `Professor`, que estende `Funcionario`, reaproveitando assim código de duas classes acima na hierarquia.

### 4. Polimorfismo e Contratos (Interfaces)
- **Interface Pagavel:** Define os contratos de cálculo de salário. Implementado em `Funcionario` e modificado/aproveitado polimorficamente por `Professor`.
- **Sobrescrita (Override):** Os métodos `toString()` em todas as classes de entidade foram sobrescritos para exibir os dados em formato tabular ou legível de acordo com os atributos específicos da classe.
- **Interface Comparable<T>:** Implementada na classe `Pessoa` (e herdada por todos). O método `compareTo` foi sobrescrito para permitir a ordenação alfabética padronizada das listas.

### 5. Composição/Agregação
A classe `Professor` possui uma referência a um objeto da classe `Materia`. Isso significa que o Professor "tem uma" Matéria. A Matéria, por sua vez, possui uma lista de Professores.

---

## Classes e Métodos

Abaixo está a documentação detalhada de **cada classe** e **cada método** implementado no sistema.

### Pacote `entidades`

#### Classe `Pessoa` (Abstrata)
Serve como classe base (superclasse) para as entidades que representam pessoas no sistema. Implementa a interface `Comparable<Pessoa>` nativa do Java.
- **Atributos:**
  - `nome` (`String`): Armazena o nome completo da pessoa. É o atributo usado para ordenação na listagem.
  - `idade` (`Integer`): Representa a idade da pessoa.
  - `cpf` (`String`): Documento de identificação único da pessoa. É a chave principal utilizada no sistema para buscas, edições e exclusões (operações do CRUD).
  - `email` (`String`): Armazena o endereço de correio eletrônico para contato.
  *Nota: Os atributos são marcados como `protected` para que as subclasses (`Aluno`, `Funcionario`) os herdem e possam manipulá-los diretamente, se necessário, sem a estrita obrigatoriedade de uso dos getters e setters.*
- **`Pessoa(...)` [Construtor]:** Inicializa os atributos em comum (nome, idade, cpf, email).
- **`getNome()`, `setNome()`, `getIdade()`, `setIdade()`, `getCpf()`, `setCpf()`, `getEmail()`, `setEmail()`:** Métodos de acesso (getters) e modificadores (setters). `setCpf` é protegido (`protected`), o que indica que não se espera que ele seja alterado livremente de fora da hierarquia.
- **`toString()`:** Sobrescreve o método original de `Object` para retornar uma String que mostra o conteúdo interno dos atributos.
- **`compareTo(Pessoa outra)`:** Compara a pessoa atual com outra baseada no `nome`, ignorando letras maiúsculas e minúsculas (`compareToIgnoreCase`). Permite o funcionamento de `Collections.sort()`.

#### Classe `Aluno`
Representa um estudante na escola. Herda da classe `Pessoa`.
- **Atributos:**
  - `nota1`, `nota2`, `nota3` (`Double`): Armazenam individualmente as três notas avaliativas do estudante (visibilidade `private`).
  - `media` (`Double`): Armazena o resultado do cálculo da média aritmética das três notas. Este atributo é preenchido dinamicamente e seu valor é atualizado sempre que uma das notas sofre alteração pelos *setters* (visibilidade `private`).
- **`Aluno(...)` [Construtor]:** Recebe os dados de `Pessoa` para repassar ao `super()` e recebe as 3 notas do aluno, calculando e setando a média automaticamente na criação.
- **`getNota1()`, `setNota1()`, `getNota2()`, `setNota2()`, `getNota3()`, `setNota3()`:** Getters e setters das notas. Ao atribuir uma nova nota pelos setters, o cálculo da média é refeito e atribuído ao atributo `media`.
- **`getMedia()`:** Retorna o valor calculado da média. Não existe `setMedia()`, pois a média é exclusivamente um campo computado.
- **`calcularMedia()`:** Retorna a soma das três notas dividida por três.
- **`toString()`:** Sobrescreve retornando uma formatação customizada que exibe o aluno como uma linha de tabela separada por pipes (`|`), unindo os atributos de `Pessoa` com notas e média.

### Pacote `entidades.empregados`

#### Interface `Pagavel`
Define o contrato para entidades que recebem remuneração.
- **`calcularSalarioBruto()`:** Assinatura para o cálculo do valor bruto (antes de descontos).
- **`adicionarImposto()`:** Assinatura para estipular o desconto de imposto.
- **`calcularSalarioLiquido()`:** Assinatura do método que retornará o salário de fato.

#### Enum `Status`
Enumeração simples contendo as constantes: `ATIVO`, `FERIAS` e `AFASTADO`. Serve para normalizar e restringir os status possíveis de um empregado do sistema, impedindo strings arbitrárias.

### Pacote `entidades.empregados.funcionario`

#### Classe `Funcionario`
Herda da classe `Pessoa` e implementa a interface `Pagavel`. Representa membros não-docentes da escola, ou atua como classe mãe para professores.
- **Atributos:**
  - `horasTrabalhadas` (`Double`): Representa o montante de horas que o funcionário dedicou ao trabalho. É protegido (`protected`) para ser acessado pelas classes filhas como `Professor`.
  - `valorHora` (`Double`): Define a remuneração recebida a cada hora de trabalho. É privado (`private`), mantendo seu encapsulamento restrito a esta classe.
  - `status` (`Status`): Um Enum que indica o estado atual do funcionário na instituição (`ATIVO`, `FERIAS` ou `AFASTADO`). Tem visibilidade `protected`.
- **`Funcionario(...)` [Construtor Completo]:** Instancia um funcionário normal com seu respectivo `valorHora`.
- **`Funcionario(...)` [Construtor Parcial]:** Omitido o `valorHora`. Destinado a subclasses (como `Professor`), onde o `valorHora` vem de outra fonte (como a classe `Materia`).
- **`calcularSalarioBruto()`:** Implementação da interface `Pagavel`. Retorna `horasTrabalhadas * valorHora`.
- **`adicionarImposto()`:** Implementação de `Pagavel`. Retorna 7,5% (0.075) em cima do salário bruto calculado.
- **`calcularSalarioLiquido()`:** Retorna o salário bruto subtraído do imposto calculado.
- **Getters e Setters (`getStatus`, `setStatus`, `getHorasTrabalhadas`, `setHorasTrabalhadas`, `getValorHora`, `setValorHora`):** Métodos padrões de acesso.
- **`toString()`:** Formatação tabular separada por pipes contendo todos os dados, formatando os salários na string de exibição com "R$ ".

### Pacote `entidades.empregados.professor`

#### Classe `Materia`
Representa uma disciplina escolar e define quanto se paga por hora nela.
- **Atributos:**
  - `nome` (`String`): Identifica qual é a disciplina escolar (ex: Matemática, Física).
  - `valorHora` (`Double`): O valor monetário pago pela hora-aula desta disciplina específica. 
  - `professores` (`ArrayList<Professor>`): Lista (`final`) que guarda a referência de todos os professores que ministram essa mesma disciplina.
- **`Materia(...)` [Construtor]:** Atribui o nome e valor hora.
- **`adicionarProfessor(Professor professor)`:** Associa um objeto `Professor` na lista interna `professores` da disciplina.
- **Getters e Setters:** `getProfessores()`, `getNome()`, `setNome()`, `getValorHora()`, `setValorHora()`.
- **`toString()`:** Retorna o nome da matéria concatenado com o valor de sua hora. Ex: `Matematica(R$60.0/hora)`.

#### Classe `Professor`
Herda de `Funcionario`. Representa o docente no sistema escolar.
- **Atributos:**
  - `materia` (`Materia`): Objeto do tipo `Materia` que este professor leciona. Exemplo de Composição/Agregação, conectando o Professor à disciplina e possibilitando recuperar o `valorHora` da matéria. Possui visibilidade `private`.
- **`Professor(...)` [Construtor]:** Recebe todos os dados gerais de Pessoa, Funcionário e um objeto do tipo `Materia`. Repassa para o `super()` (Construtor Parcial de Funcionario).
- **`calcularSalarioBruto()` [Override]:** Sobrescreve o método herdado. Em vez de usar `this.valorHora` da classe `Funcionario` (que nem foi inicializado), o Professor busca o valor dinamicamente do objeto matéria que ele ministra: `this.horasTrabalhadas * this.materia.getValorHora()`.
- **`getMateria()`, `setMateria()`:** Métodos de acesso para a referência da matéria (`setMateria` é private).
- **`getValorHora()` [Override]:** Retorna `materia.getValorHora()`. Isso encapsula o fato de que o professor não possui valorHora próprio.
- **`toString()` [Override]:** Inclui a String com o nome da disciplina do professor no meio da apresentação tabular de sua linha no terminal.

### Pacote `gerenciador`

#### Interface `Gerenciador`
Define a obrigatoriedade dos métodos do CRUD para todas as implementações concretas (aluno, funcionário, professor).
- **`cadastrar(Scanner sc)`**
- **`visualizar(Scanner sc)`**
- **`alterar(Scanner sc)`**
- **`excluir(Scanner sc)`**

#### Classes `GerenciadorAluno`, `GerenciadorFuncionario` e `GerenciadorProfessor`
Elas possuem lógicas extremamente semelhantes adaptadas para as suas respectivas classes. Todas elas implementam a interface `Gerenciador`.
- **Atributos:** 
  - Em `GerenciadorAluno`, `GerenciadorFuncionario` e `GerenciadorProfessor`: Uma coleção tipada de sua respectiva entidade, armazenando a base de dados em memória (`List<Aluno> alunos`, `List<Funcionario> funcionarios`, `List<Professor> professores`), todas `private`.
  - Em `GerenciadorProfessor`: Possui adicionalmente o atributo `List<Materia> materias` (`private`), servindo para disponibilizar o menu de seleção da disciplina ao cadastrar um novo professor e fazer a correta vinculação do objeto à matéria.
- **`Construtor`:** Recebe por parâmetro a lista de registros da classe em que será responsável (Injeção de dependência).
- **`cadastrar(Scanner sc)`:** Solicita linha a linha pelo terminal os atributos do registro. Em `GerenciadorProfessor`, exibe-se um sub-menu de disciplinas e o professor é instanciado vinculado ao objeto de matéria equivalente e adicionado à lista.
- **`visualizar(Scanner sc)`:** Exibe um sub-menu oferecendo três opções de listagem: todos os itens, um item específico por CPF, e em Ordem Alfabética. Para apresentar ordenado, cria uma cópia da lista e usa `Collections.sort(lista)` (que aciona automaticamente o `compareTo` na entidade Pessoa).
- **`alterar(Scanner sc)`:** Busca o registro na lista correspondente ao CPF digitado. Achando, aciona um loop `do-while` com um menu listando os campos que podem ser editados. Trata modificações de estados (Status) como `ATIVO`, `FERIAS` e converte para Enum. O registro é atualizado imediatamente graças à mutabilidade dos objetos na memória.
- **`excluir(Scanner sc)`:** Percorre a lista pelo índice e retira o objeto cujo CPF seja igual ao CPF informado (`alunos.remove(i)`).

### Pacote `menu`

#### Classe `Menu`
Ponto de convergência das interações do usuário.
- **Atributos:**
  - `gerenciadorAluno`, `gerenciadorFuncionario`, `gerenciadorProfessor` (`Gerenciador`): Referências polimórficas (através da interface `Gerenciador`) para acessar as instâncias que executam as lógicas de CRUD de cada respectiva entidade. Todas `private`.
  - `sc` (`Scanner`): Objeto que injeta e possibilita a entrada de dados via teclado pelo console em toda a aplicação. Visibilidade `private`.
- **`Menu(...)` [Construtor]:** Recebe e atribui às variáveis da classe os gerenciadores criados na `Programa` e a instância de entrada padrão (`Scanner`).
- **`iniciar()`:** Consiste em um loop `while(true)` com sub-menus. O usuário escolhe o escopo do que deseja gerenciar (1. Aluno, 2. Professor, 3. Funcionário). Com base nessa escolha, é atribuído o gerenciador específico a uma variável polimórfica `Gerenciador gerenciadorAtual`. Após isso, o usuário seleciona a operação CRUD (1. Cadastro, 2. Visão, etc). Graças à Inversão de Dependência, o Menu apenas precisa evocar `gerenciadorAtual.cadastrar(sc)`, por exemplo, para que a execução atinja corretamente as classes de controle adequadas sem necessitar de redundantes repetições de *if-else*.

### Pacote raiz

#### Classe `Programa`
Possui o método `main`, servindo como o local de inicialização, configuração do sistema e bootstrap.
- **`main(String[] args)`:** Inicia o `Scanner`. Para cumprir o requisito de haver 7 itens previamente cadastrados de cada tipo, ele instancia explicitamente 5 matérias, 7 alunos, 7 funcionários e 7 professores com as suas respectivas peculiaridades e as insere em `ArrayList`s iniciais. Associa os professores recém-criados em suas respectivas matérias (ex: `m1.adicionarProfessor(p1)`). 
- Finalmente, o código inicializa os `Gerenciador`es passando para o construtor essas `List`s instanciadas e, em seguida, passa estes objetos de `Gerenciador` prontos para alimentar a classe `Menu`. É chamada a função `menu.iniciar()`, começando a aplicação via terminal.