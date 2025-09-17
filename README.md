# Projeto: Escalonador com Listas de Prioridade e Prevenção de Inanição

## 📘 Disciplina
**Algoritmos e Estrutura de Dados I**
Professor: **Dimmy Karson Soares Magalhães**

## 👨‍🎓 Integrante
- Samuel Egson Milhomem Rodrigues

## 🔗 Repositório
[Link para o repositório GitHub](https://github.com/Serminho/Sistema-Operacional-iCEVOS)

---

## 📌 Descrição do Projeto
Este projeto implementa um **simulador de escalonador de processos**, utilizando listas encadeadas circulares para organizar processos em diferentes níveis de prioridade (alta, média e baixa).

Além disso, o escalonador possui:
- **Prevenção de inanição:** Após 5 execuções consecutivas de alta prioridade, um processo de prioridade média ou baixa deve ser executado.
- **Gerenciamento de recursos:** Processos que necessitam do recurso "DISCO" podem ser bloqueados e movidos para uma fila específica.
- **Simulação de execução:** A cada ciclo, os processos reduzem seus ciclos necessários até a finalização.

O objetivo é demonstrar, na prática, conceitos de **estruturas de dados, filas, escalonamento de processos e justiça no processamento**.  

---

## ⚙️ Estrutura do Código
O projeto contém os seguintes arquivos principais:
- `Main.java` → Ponto de entrada do programa.
- `Leitor.java` → Responsável por ler o arquivo `processos.txt` e carregar os processos no escalonador.
- `Processo.java` → Classe que representa um processo (nome, id, prioridade, recurso, ciclos necessários).
- `Scheduler.java` → Implementa a lógica do escalonamento, incluindo anti-inanição e bloqueio de processos.
- `ListaDeProcessos.java` → Estrutura de dados que gerencia as filas de processos.
- `Node.java` → Nó da lista encadeada.

Arquivo de entrada:
- `processos.txt` → Arquivo contendo a lista de processos no formato:

Nome;ID;Prioridade;Recurso;Ciclos

- `Nome` — string (se vazio, será tratado como "Sem nome")
- `ID` — inteiro (obrigatório, único por processo)
- `Prioridade` — inteiro (1 = Alta, 2 = Média, 3 = Baixa)
- `Recurso` — string (ex.: `DISCO` ou deixar vazio para "Sem recurso")
- `Ciclos` — inteiro (quantos ciclos de CPU o processo precisa)

**Exemplo de `processos.txt`:**

P1;1;1;DISCO;7
P2;2;2;DISCO;8
P3;3;3;;2

> Observação: use `;` (ponto e vírgula) como separador.

## 📁 Estrutura do repositório
```bash
Sistema-Operacional-iCEVOS/
├─ src/
│  ├─ Main.java
│  ├─ Leitor.java
│  ├─ Scheduler.java
│  ├─ Processo.java
│  ├─ ListaDeProcessos.java
│  └─ Node.java
├─ processos.txt         # arquivo de entrada (colocar na raiz do repositório)
├─ README.md
└─ relatorio_analise.pdf
```

---

## ▶️ Como Compilar e Executar

### 1) Requisitos mínimos
- Sistema operacional: **Windows 10/11**, **macOS** ou **Linux** (Ubuntu/Fedora/Debian)
- **Java JDK 11+** (recomendado OpenJDK 17)
- Editor (recomendado): **VS Code**

---

### 2) Instalar Java (JDK)

#### Windows (instalador GUI | recomendo Adoptium/Temurin)
1. Acesse https://adoptium.net/ e baixe o instalador do JDK (Temurin / OpenJDK) para Windows.
2. Execute o instalador e siga os passos.
3. Configure variáveis de ambiente (PowerShell Administrator)
4. Feche e reabra o terminal/PowerShell.

#### macOS (Homebrew recomendado)

Instalar JDK:
```bash
brew update
brew install openjdk@17

Link (se necessário):
```bash
sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH=$JAVA_HOME/bin:$PATH

Abra um novo terminal.
```
#### Ubuntu / Debian
```bash
sudo apt update
sudo apt install openjdk-17-jdk -y
```
#### Fedora
```bash
sudo dnf install java-17-openjdk-devel -y
```
---

### 3) Verificar instalação
No terminal:
```bash
java -version
javac -version
```
Deverá aparecer a versão do Java/Javac (ex.: `openjdk version "17.0.x"`).

---

### 4) Instalar VS Code (opcional)
- Baixe e instale: https://code.visualstudio.com/  
- Instale extensão **Java Extension Pack** (Language Support for Java, Debugger for Java, etc.)

---

### 5) Clonar o repositório (ou copiar arquivos)
Se usar Git:
```bash
git clone https://github.com/Serminho/Sistema-Operacional-iCEVOS
cd NOME_REPO
```
Se não usar Git, copie o diretório do projeto para sua máquina e abra-o no VS Code.

---

### 6) Colocar `processos.txt`
Se já não possuir, crie o arquivo `processos.txt` na raiz do repositório (no mesmo nível que `src/`) com o formato já descrito acima. Exemplo:
```bash
P1;1;1;DISCO;7
P2;2;2;DISCO;8
P3;3;3;;2
```
---

### 7) Compilar (linha de comando)
No terminal, dentro da pasta do repositório:

**Opção A — compilar todos os .java para um diretório `out`:**
```bash
javac -d out src/*.java
```

**Opção B — compilar direto na pasta `src` (menos recomendado):**
```bash
cd src
javac *.java
```

---

### 8) Executar
Ainda na raiz do projeto:

Se usou `-d out`:
```bash
java -cp out Main
```

Se compilou na pasta `src`:
```bash
cd src
java Main
```

> Observação: `Main` neste projeto carrega `processos.txt` por caminho relativo, garanta que você executa o comando a partir da pasta correta (raiz do projeto ou `out`/`src` conforme compilação).

---

## Execução via VS Code
- Abra a pasta do projeto no VS Code.
- Abra `Main.java` e clique no botão Run (ou configure `launch.json`).
- Garanta que `processos.txt` esteja na raiz do workspace (ou ajuste argumentos).

---

## 📄 Exemplo de Saída

| Ciclo numero: 1 | Executando processo: P1
| Ciclo numero: 2 | Executando processo: P1
| Ciclo numero: 3 | Executando processo: P2
...
Todos os processos foram concluídos.

A saída inclui: estado das filas (Alta/Média/Baixa), bloqueados, processo em execução e eventos (bloqueio, desbloqueio, término).

---

## Erros comuns e soluções rápidas

- **`javac` não encontrado** → JDK não está no PATH; verifique `JAVA_HOME` e `PATH`.
- **`NoClassDefFoundError` / `Could not find or load main class`** → execute com `-cp out` e verifique que compilou com `-d out`.
- **`ArrayIndexOutOfBoundsException` no Leitor** → arquivo `processos.txt` com formato errado; verifique separador `;` e linhas vazias.
- **`NumberFormatException`** → campos ID / Prioridade / Ciclos não numéricos; corrija o arquivo.
- **Processo bloqueado sempre que executa** → comportamento do projeto: na primeira vez que um processo solicita `DISCO` ele é movido para a fila de bloqueados (especificação do trabalho).

---

## 📚 Autor

Desenvolvido por **Samuel Egson Milhomem Rodrigues** como parte da disciplina *Algoritmos e Estrutura de Dados I*.