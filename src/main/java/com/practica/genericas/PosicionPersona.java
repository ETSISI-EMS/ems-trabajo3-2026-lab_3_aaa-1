package com.practica.genericas;


import com.practica.excecption.EmsInvalidNumberOfDataException;

public class PosicionPersona {
	private Coordenada coordenada;
	private String documento;
	private FechaHora fechaPosicion;
	private static int MAX_DATOS_LOCALIZACION = 6;

	public static PosicionPersona parsePosicionPersona(String[] datos) throws EmsInvalidNumberOfDataException {
		if (datos.length != MAX_DATOS_LOCALIZACION) {
			throw new EmsInvalidNumberOfDataException("Cantidad incorrecta de campos introducida: " + datos.length);
		}
		String documento = datos[1];
		FechaHora fechaPosicion = FechaHora.parseFecha(datos[2], datos[3]);
		Coordenada coordenada = new Coordenada(Float.parseFloat(datos[4]), Float.parseFloat(datos[5]));

		return new PosicionPersona(coordenada, documento, fechaPosicion);
	}

	public PosicionPersona() {

	}

	public PosicionPersona(Coordenada coordenada, String documento, FechaHora fechaPosicion) {
		this.coordenada = coordenada;
		this.documento = documento;
		this.fechaPosicion = fechaPosicion;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public FechaHora getFechaPosicion() {
		return fechaPosicion;
	}
	public void setFechaPosicion(FechaHora fechaPosicion) {
		this.fechaPosicion = fechaPosicion;
	}
	@Override
	public String toString() {
		String cadena = "";
        cadena += String.format("%s;", getDocumento());
        FechaHora fecha = getFechaPosicion();        
        cadena+=String.format("%02d/%02d/%04d;%02d:%02d;", 
	        		fecha.getFecha().getDia(), 
	        		fecha.getFecha().getMes(), 
	        		fecha.getFecha().getAnio(),
	        		fecha.getHora().getHora(),
	        		fecha.getHora().getMinuto());
        cadena+=String.format("%.4f;%.4f\n", getCoordenada().getLatitud(), 
	        		getCoordenada().getLongitud());
	
		return cadena;
	}
		
}
