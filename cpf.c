#include<stdio.h>
#include<string.h>//para stdlen e strcspn
#include"verificapf.h"
int main()
{
        char resposta;
        do{
                char cpf[12];
                fflush(stdin);//limpa buffer do teclado para leitura
                puts("digite o CPF");
                if(fgets(cpf, sizeof(cpf), stdin) != NULL)
                {//ler cpf, no tamanho de cpf, leitura no emulador de terminal
                        cpf[strcspn(cpf, "\n")] = '\0';//a função strcspn ler cpf, busta o caracter de quebra de linha e o substitui por caractert nullo
                 }
                else
                {
                        return 1;//se leitura for errada retorna null
                }

                if(verifica(cpf))
                {
                        printf("CPF %s é valido\n",cpf);
                }
                else
                {
                        printf("CPF %s não é valido\n",cpf);
                }
                printf("Deseja continuar?(S/N)");
                scanf("%1c",&resposta);
                while(getchar() != '\n');//limpa bufer caso usuario digite mais de 1 caracte
        }while(resposta == 'S');
        return 0;
}

