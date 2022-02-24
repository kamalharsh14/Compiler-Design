%{
	int vowels=0;
	int characters=0;
	int words=0;
%}

%%
[aeiouAEIOU] {vowels++;}
" " {words++; characters++;}
[\t\n] {words++;}
[^\n\t] {characters++;}
%%
int yywrap(){}
int main()
{
	printf("Enter the string :");
	yylex();
	printf("Number of Vowels are: %d\n", vowels);
	printf("Number of Characters are: %d\n", characters+vowels);
	printf("Number of Words are: %d\n", words);
	return 0;
}
