// spec.js

//Patron page object
describe('Prueba flujo principal', function() {
    it('should have a title', function() {
      browser.get('http://localhost:4200/home');
  
      expect(browser.getTitle()).toEqual('Moto-YA');
    });
  });

  describe('Navegar a ventana registro moto', function(){
    it('navegar a registro moto', function(){
      browser.get('http://localhost:4200/home');
      element(by.id('nav-crearMoto')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/moto');
    })
  });



  describe('Crear moto', function() {
    it('creacion nueva moto', function() {
      browser.get('http://localhost:4200/moto');
      element(by.id('placa')).sendKeys("ZZZ014");
      element(by.id('marca')).sendKeys("pulsar");
      element(by.id('modelo')).sendKeys(2018);
      element(by.id('referencia')).sendKeys("ns200");
      element(by.id('cilindrada')).sendKeys(200);
      element(by.id('precioAlquiler')).sendKeys(5000);
      element(by.id('botonCrearMoto')).click();
      element(by.buttonText('OK')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/home'); 
    });
  });

  describe('Navegar a ventana registro cliente', function(){
    it('navegar a registro cliente', function(){
      browser.get('http://localhost:4200/home');
      element(by.id('nav-crearCliente')).click();
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/cliente');
    });
  });

  describe('Crear cliente', function() {
    it('creacion nuevo cliente', function() {
      browser.get('http://localhost:4200/cliente');
      element(by.id('cedula')).sendKeys("1102");
      element(by.id('nombre')).sendKeys("Usuario");
      element(by.id('fechaNacimineto')).sendKeys("2018-10-10");
      element(by.id('telefono')).sendKeys(12345);
      element(by.id('correo')).sendKeys("user@gmail.com");
      element(by.id('categoriaPase')).sendKeys("A1");
      element(by.id('botonCrearCliente')).click();
      element(by.buttonText('OK')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/home'); 
    });
  });