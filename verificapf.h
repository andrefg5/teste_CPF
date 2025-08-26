#include<stdio.h>
#include<string.h>//para stdlen e strcspn
#include<stdint.h>//para usar o uint8_t
#include<stdbool.h>//para usar bool

bool verifica(char cpf[12])
{
        if(strlen(cpf) != 11)return false;

        uint8_t n[11];
        for(int i = 0; i < 11; i++)
        {
                if (cpf[i] < '0' || cpf[i] > '9') return false;//verifica se é nummero entre 0 e 9

                n[i] = cpf[i] - '0';
        }

        bool tigual = true;
        for(int i = 0; i < 11; i++)
        {
                if(n[i] != n[0]){ //verifica todos com o primeiro elemento
                        tigual = false;
                        break;
                }
        }

        if(tigual) return 1;//finaliza se todos forem iguais
        
        int soma1 = n[0] * 10 + n[1] * 9 + n[2] * 8 + n[3] * 7 + n[4] * 6 + n[5] * 5 + n[6] * 4 + n[7] * 3 + n[8] * 2;
        int resto1 = (soma1 *10) % 11;

        if(resto1 == 10) resto1 = 0;
        int soma2 =n[0] * 11 + n[1] * 10 + n[2] * 9 + n[3] * 8 + n[4] * 7 + n[5] * 6 + n[6] * 5 + n[7] * 4 + n[8] * 3 + n[9] * 2;
        int resto2 = (soma2 * 10) % 11;

        if(resto2 == 10) resto2 = 0;

        if(resto1 != n[9]) return false;
        if(resto2 != n[10]) return false;
}
