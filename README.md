



## **OdontoCare**



Nome: Beatriz Silva RM552600 --->  Responsável pelo desenvolvimento da API em Java Spring Boot e integração com o banco de dados Oracle.Também responsavel pela parte de mobile. 
Nome: Vitor Onofre Ramos RM553241  -----> Criação do banco de dados e pela criação em C#
Nome: Pedro Henrique soares araujo - RM553801 ------> Responsavel pela analise dos sinistros usando IA e pela parte de testes e Devops. 

## **Cronograma de Atividades**

| Data        | Responsável | Atividade                                                                                      | Status        |
|-------------|-------------|------------------------------------------------------------------------------------------------|---------------|
| **08/10**   | Todos       | Definição de requisitos e alinhamento de funções e cronograma                                  | Concluído     |
| **10/10**   | Beatriz     | Criação da API em Java com Spring Boot - Configuração inicial                                  | Concluído     |
| **12/10**   | Vitor       | Estruturação do banco de dados Oracle e definição das tabelas iniciais                         | Concluído     |
| **14/10**   | Pedro       | Configuração do ambiente DevOps - configuração do Docker para CI/CD                            | Concluído     |
| **16/10**   | Beatriz     | Desenvolvimento do CRUD de Pacientes - entidade, DTOs e repositórios                           | Concluído     |
| **18/10**   | Vitor       | Criação das procedures e triggers no banco de dados Oracle                                     | Concluído     |
| **19/10**   | Beatriz     | Desenvolvimento da tela de login no aplicativo Android                                        | Concluído     |
| **20/10**   | Pedro       | Estruturação do plano de QA e casos de teste iniciais                                         | Concluído     |
| **22/10**   | Vitor       | Desenvolvimento da integração de C# com banco de dados Oracle                                 | Concluído     |
| **24/10**   | Beatriz     | Desenvolvimento da tela de funcionalidades principais no app mobile Android                   | Concluído     |
| **25/10**   | Pedro       | Criação de testes automatizados para a API e integração no pipeline DevOps                    | Concluído     |
| **27/10**   | Beatriz     | Desenvolvimento da tela de agendamentos no app Android                                        | Concluído     |
| **28/10**   | Vitor       | Implementação de rotinas de segurança e backups no banco de dados                             | Concluído     |
| **30/10**   | Pedro       | Início do desenvolvimento do modelo de IA para análise de sinistros                           | Em Andamento  |
| **01/11**   | Beatriz     | Finalização das telas de perfil e notificações no aplicativo Android                          | Concluído     |
| **02/11**   | Pedro       | Testes de carga e segurança no ambiente QA                                                    | Concluído     |
| **04/11**   | Vitor       | Ajustes finais no banco de dados e otimização de consultas                                    | Concluído     |
| **05/11**   | Pedro       | Implementação final e integração do modelo de IA na aplicação                                 | Concluído     |
| **06/11**   | Beatriz     | Revisão e testes do app Android e ajuste de bugs detectados                                   | Em Andamento  |



## **Explicação do Projeto**

Sinistros na odontologia podem referir-se a eventos adversos, como erros de
diagnóstico, tratamentos inadequados ou complicações que resultam em danos
aos pacientes ou à prática clínica. A prevenção desses sinistros é crucial para
garantir a segurança dos pacientes, reduzir custos e melhorar a eficiência dos
atendimentos. O sistema visa não apenas facilitar o agendamento de
consultas, mas também implementar medidas proativas que ajudem a prevenir
sinistros. Para isso, o sistema incorporará várias funcionalidades:

1. Registro Completo de Pacientes:
o Histórico Médico Detalhado: O sistema manterá um histórico
detalhado de cada paciente, incluindo condições médicas préexistentes, alergias e tratamentos anteriores. Isso ajuda os
dentistas a considerar fatores de risco ao planejar tratamentos.

2. Alertas Personalizados:
o Lembretes e Alertas: O sistema enviará lembretes automáticos
para os pacientes sobre consultas, tratamentos recomendados e
exames periódicos. Alertas também serão emitidos para dentistas
sobre potenciais contraindicações ou interações com
medicamentos, baseados nas informações do histórico do
paciente.

3. Protocólos de Tratamento:
o Base de Dados de Protocolos: O sistema incluirá protocolos de
tratamento odontológico baseados em melhores práticas. Isso
ajudará a padronizar os atendimentos, reduzindo a probabilidade
de erros.

4. Análise de Dados e Tendências:
o Relatórios de Análise de Sinistros: O sistema poderá gerar
relatórios que analisam padrões de sinistros, como erros de
diagnóstico e complicações frequentes. Essas informações
permitirão que a administração da clínica identifique áreas de
melhoria e implemente ações corretivas.

A implementação da virtualização no Sistema de Gerenciamento de Consultas
Odontológicas com Alertas traz diversas vantagens que suportam a eficiência e
a segurança do sistema, alinhando-se com os objetivos de prevenção de
sinistros. Algumas dessas vantagens são:

Facilidade na Implementação de Ferramentas de Monitoramento:
Ambientes virtualizados podem integrar facilmente ferramentas de
monitoramento e análise. Isso é vital para acompanhar métricas de
desempenho, identificar potenciais problemas e garantir que o sistema esteja
operando conforme esperado, prevenindo situações que possam levar a
sinistros

Facilidade de Escalabilidade: A virtualização permite escalar rapidamente os
recursos conforme a demanda do sistema aumenta. Com a virtualização,
podemos provisionar novas instâncias de forma rápida e fácil, adaptando-se a
picos de uso, como períodos de agendamento de consultas.
Economia de Recursos: Ao usar máquinas virtuais ou containers, podemos
maximizar a utilização dos recursos do servidor. Isso significa que mais
aplicações podem ser executadas no mesmo hardware, reduzindo custos
operacionais.

Isolamento de Ambientes: A virtualização permite criar ambientes isolados
para desenvolvimento, testes e produção. Isso ajuda a evitar conflitos de
dependências e configurações, garantindo que cada parte do sistema funcione
conforme esperado em ambientes específicos.

  ## **Estrutura do Projeto**

                                                              
Este sistema tem como objetivo gerenciar consultas odontológicas, facilitando o agendamento de pacientes, dentistas e histórico de consultas. Além disso, o sistema visa a prevenção de sinistros odontológicos, como erros de diagnóstico ou tratamentos inadequados, melhorando a segurança dos pacientes e a eficiência dos atendimentos.

O projeto é organizado nas seguintes classes principais:

Paciente: Entidade responsável por armazenar os dados do paciente.
Dentista: Entidade responsável pelo cadastro dos dentistas.
Consulta: Responsável pelo agendamento e histórico de consultas.
Histórico de Consultas: Armazena o histórico de todas as consultas realizadas.

## **Relatório da Segunda Sprint do Projeto OdontoCare**

Nesta segunda sprint do projeto OdontoCare, o foco foi aprimorar a API REST que gerencia informações sobre clínicas odontológicas. O objetivo principal foi implementar funcionalidades que garantissem um gerenciamento eficiente das clínicas, proporcionando uma interface intuitiva e segura para os usuários.

Principais Implementações
Durante esta sprint, foram adicionadas diversas funcionalidades ao ClinicaOdontologicaController, que agora inclui métodos para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em clínicas odontológicas. As melhorias implementadas foram:

Busca de Clínicas Próximas:

Implementação do método getClinicasProximas, que utiliza o serviço de geolocalização para encontrar clínicas próximas a um endereço específico. Esse recurso é crucial para a experiência do usuário, pois permite que ele localize clínicas de forma rápida e eficiente.
Obtenção de Clínica por ID:

Criação do método getClinica, que permite a recuperação de informações detalhadas sobre uma clínica específica. Isso é fundamental para operações que exigem o acesso a dados completos de uma clínica.
Listagem de Todas as Clínicas:

O método getAllClinicas foi implementado para retornar todas as clínicas cadastradas. Esta funcionalidade é importante para permitir que os usuários visualizem a lista completa de clínicas disponíveis.
Criação de Nova Clínica:

O método createClinica foi desenvolvido para permitir a adição de novas clínicas à base de dados. Ele aceita dados no formato de um ClinicaOdontologicaDTO, que ajuda a encapsular as informações necessárias e a garantir a segurança dos dados.
Atualização de Clínica Existente:

Implementação do método updateClinica, que possibilita a atualização das informações de clínicas existentes. Isso garante que os dados mantidos na base estejam sempre atualizados e relevantes.
Remoção de Clínica:

O método deleteClinica foi adicionado para permitir a exclusão de clínicas da base de dados, oferecendo uma funcionalidade essencial para o gerenciamento de informações.
Criação em Lote:

Foi implementado um método que permite a criação de múltiplas clínicas de uma só vez, facilitando a inclusão de grandes volumes de dados e melhorando a eficiência da API.
Implementação de HATEOAS:

Uma das adições mais significativas foi a implementação do HATEOAS (Hypermedia as the Engine of Application State). Cada resposta da API agora inclui links relevantes que permitem ao cliente navegar pelas diferentes operações disponíveis. Por exemplo, ao buscar informações sobre uma clínica, o retorno inclui links para visualizar todas as clínicas, obter dados sobre a clínica em questão e realizar atualizações ou deleções, proporcionando uma navegação mais intuitiva e conectada entre os recursos da API.
Essa abordagem não apenas melhora a usabilidade da API, mas também a torna mais autoexplicativa, facilitando a vida dos desenvolvedores que a utilizam. O uso de HATEOAS é fundamental para criar APIs RESTful mais robustas e alinhadas com as melhores práticas do desenvolvimento de software.
Benefícios das Implementações
As melhorias realizadas nesta sprint não apenas ampliaram a funcionalidade da API, mas também tornaram a estrutura do código mais modular e fácil de manter. O uso de DTOs (Data Transfer Objects) para a troca de dados entre o cliente e o servidor contribuiu para a segurança e eficiência da aplicação, ao evitar a exposição direta da entidade.

Além disso, a implementação de rotas distintas e a lógica para determinar clínicas próximas otimizam a experiência do usuário, permitindo que ele encontre rapidamente serviços de saúde disponíveis em sua área. Com o uso do HATEOAS, o usuário tem um acesso mais dinâmico aos recursos, promovendo uma navegação fluida entre as diferentes operações disponíveis na API.

## **Endpoints Testados:**

GET: Recuperação de todas as clínicas odontológicas e das clínicas próximas com base em um endereço.
POST: Criação de novas clínicas odontológicas, incluindo a funcionalidade de criar em lote, permitindo a adição de múltiplas clínicas em uma única requisição.
PUT: Atualização de informações de clínicas odontológicas existentes.
DELETE: Remoção de clínicas odontológicas específicas.
Testes de erro: Verificação de respostas adequadas para cenários de erro, como tentativas de acessar clínicas inexistentes ou falhas na validação dos dados.

Os testes realizados estão documentados e disponíveis na seguinte pasta do repositório GitHub do projeto: Endpoints Postman - OdontoCare API

Instruções para rodar a aplicação

 1. Pré-requisitos

Antes de iniciar a aplicação, é necessário garantir que os seguintes softwares estejam instalados:

- **JDK 17** ou superior.
- **Maven**.
- **Banco de Dados Oracle**.
- **Postman** (para testar a API).

 2. Clonar o Repositório

3. Rodar a Aplicação
  Usando IntelliJ IDEA:
  Abra o projeto no IntelliJ IDEA.
  Encontre a classe principal Application.java e execute.

Listagem de Endpoints (Documentação da API)

Pacientes

GET /api/pacientes: Retorna todos os pacientes cadastrados.
POST /api/pacientes: Cria um novo paciente.
GET /api/pacientes/{id}: Retorna um paciente específico pelo ID.
PUT /api/pacientes/{id}: Atualiza um paciente específico.
DELETE /api/pacientes/{id}: Remove um paciente pelo ID.

Consultas

GET /api/consultas: Retorna todas as consultas agendadas.
POST /api/consultas: Agendar uma nova consulta.
GET /api/consultas/{id}: Retorna uma consulta específica pelo ID.
PUT /api/consultas/{id}: Atualiza uma consulta existente.
DELETE /api/consultas/{id}: Remove uma consulta.

Dentistas

GET /api/dentistas: Retorna todos os dentistas cadastrados.
POST /api/dentistas: Cria um novo dentista.

Link para a Proposta Tecnológica
Vídeo de Apresentação: https://www.youtube.com/watch?v=Yg7mFEHHvv0 

Neste vídeo, detalhamos a proposta tecnológica, explicamos o público-alvo e discutimos como nossa aplicação resolve os problemas de sinistros na odontologia.

## **Diagrama de classes** 
![Diagrama](https://github.com/bia98silva/OdontoCare/blob/master/Imagens/DiagramaDeClasssesOdontoCare.drawio.png)

## **Diagrama DER** 
![der](https://github.com/bia98silva/OdontoCare/blob/master/Imagens/Diagrama_DER.png)


## **Etapas do Desenvolvimento** 
![Desenvolvimento](https://github.com/bia98silva/OdontoCare/blob/master/Imagens/OdontoCare.drawio.png)



