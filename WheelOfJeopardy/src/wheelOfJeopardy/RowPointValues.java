/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelOfJeopardy;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Heather
 */
public class RowPointValues {
    private StringProperty cell_1;
    private StringProperty cell_2; 
    private StringProperty cell_3;
    private StringProperty cell_4;
    private StringProperty cell_5;
    private StringProperty cell_6;
    
    public void setCell_1(String value) { 
        cell_1Property().set(value); 
    }
    
    public String getCell_1() { 
        return cell_1Property().get(); 
    }
    
    public StringProperty cell_1Property() { 
         if (cell_1 == null){
             cell_1 = new SimpleStringProperty(this, "");
         }
         return cell_1; 
    }
    
    public void setCell_2(String value) { 
        cell_2Property().set(value); 
    }
    
    public String getCell_2() { 
        return cell_2Property().get(); 
    }
    
    public StringProperty cell_2Property() { 
         if (cell_2 == null){
             cell_2 = new SimpleStringProperty(this, "");
         }
         return cell_2; 
    }
        
     public void setCell_3(String value) { 
        cell_3Property().set(value); 
    }
    
    public String getCell_3() { 
        return cell_3Property().get(); 
    }
    
    public StringProperty cell_3Property() { 
         if (cell_3 == null){
             cell_3 = new SimpleStringProperty(this, "");
         }
         return cell_3; 
    }
    
    public void setCell_4(String value) { 
        cell_4Property().set(value); 
    }
    
    public String getCell_4() { 
        return cell_4Property().get(); 
    }
    
    public StringProperty cell_4Property() { 
         if (cell_4 == null){
             cell_4 = new SimpleStringProperty(this, "");
         }
         return cell_4; 
    }
     
    public void setCell_5(String value) { 
        cell_5Property().set(value); 
    }
    
    public String getCell_5() { 
        return cell_5Property().get(); 
    }
    
    public StringProperty cell_5Property() { 
         if (cell_5 == null){
             cell_5 = new SimpleStringProperty(this, "");
         }
         return cell_5; 
    }
    
    public void setCell_6(String value) { 
        cell_6Property().set(value); 
    }
    
    public String getCell_6() { 
        return cell_6Property().get(); 
    }
    
    public StringProperty cell_6Property() { 
         if (cell_6 == null){
             cell_6 = new SimpleStringProperty(this, "");
         }
         return cell_6; 
    }
     
    public RowPointValues () {
    }

 
    public RowPointValues (String cell1, String cell2, String cell3, 
            String cell4, String cell5, String cell6) {
        
        setCell_1(cell1);
        setCell_2(cell2);
        setCell_3(cell3);
        setCell_4(cell4);
        setCell_5(cell5);
        setCell_6(cell6);
    }

}
