Para testar o servi�o, utilize quailquer ferramenta de acesso http 
(Um browser conectado na internet j� basta ou uma ferramenta como
SoapUI ou o Chrome Advanced Rest Client).

Para realizar os testes, utilize o servidor de IP: 18.191.250.94
(servidor cloud Amazon EC2 gratuito).

A lista de servi�os dispon�veis �:

M�todo GET:
http://18.191.250.94/XYInc/poi/test
-- Testa se o Webservice est� online.

M�todo GET:
http://18.191.250.94/XYInc/poi/get
-- Retorna uma lista com todos os POI cadastrados

M�todo POST:
http://18.191.250.94/XYInc/poi/insere/{nome}/x/{cordX}/y/{cordY}
-- Insere um novo POI
	-- Substitua {nome} pelo nome do POI
	-- Substitua {cordX} pela coordenada X do POI
	-- Substitua {cordY} pela coordenada Y do POI

M�todo GET:
http://18.191.250.94/XYInc/poi/near/x/{cordX}/y/{cordY}/max/{distMax}
-- Retorna uma lista de POIs que est�o a no m�ximo {distMax} metros 
da localiza��o apresentada
	-- Substitua {cordX} pela coordenada X do local a ser consultado
	-- Substitua {cordY} pela coordenada Y do local a ser consultado
	-- Substitua {distMax} pela distancia m�xima em metros que deseja
consultar

M�todo GET:
http://18.191.250.94/XYInc/poi/get/{codigo}
-- Pesquisa pelo POI de ID {codigo}
	-- Substitua {codigo} pelo ID do POI desejado

M�todo DELETE:
http://18.191.250.94/XYInc/poi/delete/{codigo}
-- Remove um POI existente
	-- Substitua {codigo} pelo ID do POI que deseja remover