/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Curso;
import modelo.CursoDAO;
import modelo.Profesor;
import modelo.ProfesorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author polod
 */
public class ComboBox {
 
    private JComboBox<String> combox;
    
   /*Variables de items de profesor */
   private final ProfesorDAO profesores = new ProfesorDAO(); 
   private List<ComboItem> itemsProfe = new ArrayList<>();
   private ComboItem itemProfe;
   
   /*Variables de items de cursos*/
   private final CursoDAO cursos = new CursoDAO(); 
   private List<ComboItem> itemsCurso = new ArrayList<>();
   private ComboItem itemCurso;
   
    public ComboBox() {
        
    }
    
    public ComboBox(JComboBox<String> combox) {
        this.combox = combox;
    }
    
    
    //carga las opciones del comboBox para elegir al profesor 
    public void getProfesoresComboBox(){
           
        List<Profesor>profesoresData;
        profesoresData = profesores.selectProfesores();            
        String optionProfesores;

          
        for(Profesor p : profesoresData){   
           optionProfesores = p.getNombre() + " " +  p.getApellidos();
            itemProfe = new ComboItem(optionProfesores,p.getIdentificacion());
            combox.addItem(optionProfesores);
            itemsProfe.add(itemProfe);                 
        }       
    }  

   //carga las opciones del comboBox para elegir el curso
   public void getCursosComboBox(){
           
        List<Curso>cursosData;
        cursosData = cursos.selectCursos();            
        String optionCursos;
      
        for(Curso c : cursosData){   
            optionCursos = c.getNombre();
            itemCurso = new ComboItem(optionCursos,c.getCodigo());
            combox.addItem(optionCursos);
            itemsCurso.add(itemCurso); 
            
        }        
    }  
    
   //devuelve el valor de la selecion del profesor
   public int SelecionComboBoxProfesor(JComboBox<String> combox){ 
       //toma el valor elegido en el combobox
        String selectItem =  (String) combox.getSelectedItem();
       
        //recorre cada item del array de los items 
        for(ComboItem itms : itemsProfe){  
            //donde el item seleccionado coincida con uno de la lista
            if(selectItem == itms.getKey()){          
                System.out.println(itms.getValue()+ ":" + itms.getKey());
                //va a devolver el valor de ese item, la id del profesor
                return itms.getValue();
            }                         
        }             
        return 0;       
    } 
   
   //devuelve el valor de la selecion del curso
    public int SelecionComboBoxCurso(JComboBox<String> combox){         
        String selectItem =  (String) combox.getSelectedItem();
      
        for(ComboItem itms : itemsCurso){          
            if(selectItem == itms.getKey()){          
                System.out.println(itms.getValue()+ ":" + itms.getKey());
                return itms.getValue();
            }                         
        }             
        return 0;       
    } 
    
    
    
}
