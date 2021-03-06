package sample1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import sample1.helpers.HelperVarios;
import sample1.helpers.StockMockSimulator;
import sample1.model.Cerveza;
import sample1.model.Lugar;
import sample1.model.LugarStock;

@Stateless
public class EntityManagerMock {

	/* esto esta static para mockear, 
	 * sino aca ira a la DB a buscar la data
	 * */
	public static List<Cerveza> cervezasTipo = StockMockSimulator.listadoCervezas();
	public static List<Lugar> lugares = StockMockSimulator.listadoLugares();
	private static List<LugarStock> lugaresStock = new ArrayList<>();
	
	public List<Cerveza> getCervezasTipo(){
		return cervezasTipo;
	}
	
	public List<Lugar> getLugares(){
		return lugares;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param radio expresado en km ? FIXME
	 * @return
	 */
	public List<Lugar> getLugaresXY(Double x, Double y , Double radio){
		return lugares.stream().filter(lugar -> HelperVarios.filtraDistancia(lugar,x,y,radio)).collect(Collectors.toList());
	}

	public List<LugarStock> getStockCervezaYgenteParaLugares(List<Lugar> lugaresXY) {
		return StockMockSimulator.generarLugarStockPara(lugaresXY);
	}
}
