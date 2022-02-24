%{
#include<stdio.h>
%}
%%
(a|A)[a-z][0-9](a|A) {printf("matching");}
(a|A)+ {printf("matching");}
.* {printf("not matching");}
%%

int yywrap()
{
}
int main()
{
yylex();
return 0;
}

