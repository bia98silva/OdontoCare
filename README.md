



## **OdontoCare**



Nome: Beatriz Silva RM552600 --->  Responsável pelo desenvolvimento da API em Java Spring Boot e integração com o banco de dados Oracle.Também responsavel pela parte de mobile. 
Nome: Marcelo Mendes Galli RM553654 2TDSPC-2024 -----> Criação do banco de dados e pela criação em C#
Nome: Pedro Henrique soares araujo - RM553801 ------> Responsavel peal analise dos sinistros usando IA e pela parte de testes e Devops. 

## **Cronograma de Atividades**

Data	Responsável	Atividade	Status
08/out	Todos	definição de requisitos e alinhamento de funções e cronograma	
10/out	Beatriz	Criação da API em Java com Spring Boot - Configuração inicial 
12/out	Vitor	Estruturação do banco de dados Oracle e definição das tabelas iniciais	
14/out	Pedro	Configuração do ambiente DevOps - configuração do Docker para CI/CD	
16/out	Beatriz	Desenvolvimento do CRUD de Pacientes - entidade, DTOs e repositórios	
18/out	Vitor	Criação das procedures e triggers no banco de dados Oracle	
19/out	Beatriz	Desenvolvimento da tela de login no aplicativo Android	
20/out	Pedro	Estruturação do plano de QA e casos de teste iniciais	
22/out	Vitor	Desenvolvimento da integração de C# com banco de dados Oracle	
24/out	Beatriz	Desenvolvimento da tela de funcionalidades principais no app mobile Android	
25/out	Pedro	Criação de testes automatizados para a API e integração no pipeline DevOps	
27/out	Beatriz	Desenvolvimento da tela de agendamentos no app Android	
28/out	Vitor	Implementação de rotinas de segurança e backups no banco de dados	
30/out	Pedro	Início do desenvolvimento do modelo de IA para análise de sinistros	
01/nov	Beatriz	Finalização das telas de perfil e notificações no aplicativo Android	
02/nov	Pedro	Testes de carga e segurança no ambiente QA	
04/nov	Vitor	Ajustes finais no banco de dados e otimização de consultas	
05/nov	Pedro	Implementação final e integração do modelo de IA na aplicação	
06/nov	Beatriz	Revisão e testes do app Android e ajuste de bugs detectados	




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

                                                              Estrutura do Projeto

                                                              
Este sistema tem como objetivo gerenciar consultas odontológicas, facilitando o agendamento de pacientes, dentistas e histórico de consultas. Além disso, o sistema visa a prevenção de sinistros odontológicos, como erros de diagnóstico ou tratamentos inadequados, melhorando a segurança dos pacientes e a eficiência dos atendimentos.

O projeto é organizado nas seguintes classes principais:

Paciente: Entidade responsável por armazenar os dados do paciente.
Dentista: Entidade responsável pelo cadastro dos dentistas.
Consulta: Responsável pelo agendamento e histórico de consultas.
Histórico de Consultas: Armazena o histórico de todas as consultas realizadas.


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



