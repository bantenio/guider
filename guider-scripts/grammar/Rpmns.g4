grammar Rpmns;

@header { package cn.bytengine.guider.scripts.antlr; }

s: 'Hello' ID | WS;
ID: [a-zA-Z]+;
WS : [ \t\r\n]+ -> skip ;