/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectforoop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class DiseasepageController implements Initializable {
    
      @FXML
    private TableView<Disease> table;

    @FXML
    private TableColumn<Disease, String> name;

    @FXML
    private TableColumn<Disease, String> symp;

    @FXML
    private TableColumn<Disease, String> treat;
    
    ObservableList<Disease> list = FXCollections.observableArrayList(
    
            new Disease("Acute Myeloid Leukemia","Pale Skin, tiredness, breathlessness","Chemotherapy"),
            new Disease("Addision's disease","Fatigue, muscle weakness, increased thirst","Medication to replace missing hormones"),
            new Disease("Alzheimer's disease","Confusion, disoreintation, problems with speech","no cure"),
            new Disease("Angioedema","Swelling of eyes, lips, other body parts","Antihistamines and oral steroids can be used"),
            new Disease("Bipolar disorder","Depression, mood swings, mania","lithium, valproic acid"),
            new Disease("Bone cancer","Bone pain, bone lumps, weak bone breakage","Chemotherapy, radiotherapy, amputation"),
            new Disease("Bronchitis","Lung inflamation","no cure"),
            new Disease("Bulimia","Binge eating pattern, weight anxiousness","cognitive behavioral therapy"),
            new Disease("Catarrh","runny nose, headache, facial pain","decongestants, antihistamines"),
            new Disease("Cellulitis","Red, hot, swolen skin","Antibiotics"),
            new Disease("Chest infection","persistent cough, breathlessness","Panadol"),
            new Disease("Chilblains","Swollen skin, red or blue skin","calamine, witch hazel"),
            new Disease("Deaf blindness","not hearing properly","no cure"),
            new Disease("Dementia","Memory loss, less mental agility","cholinesterase inhibitors"),
            new Disease("Depression","anxiety, feelings of fear and hopelessness","cognitive behavioral therapy, interpersonal therapy"),
            new Disease("Diarrhoea","Food allergy, stomach ache","oral rehydration solution"),
            new Disease("Earache","Pain in ear","Panadol"),
            new Disease("Ebola virus","fever, headache, joint and muscle pain","no licensed treatment"),
            new Disease("Epilepsy","seizures","anti epileptic drugs"),
            new Disease("Eye cancer","Shadows, flashes of light, blurred vision","external radiotherapy, surgery"),
            new Disease("Fever","Headache, tiredness","Panadol"),
            new Disease("Fibroids","painful periods, tummy/back pain","tranexamic acid, anti inflammatory medicines"),
            new Disease("Flu","Headache","Panadol"),
            new Disease("Food poisioning","nausea, vomiting","Antidiarrheal medicines"),
            new Disease("Gallstones","abdominal pain","keyhole surgery"),
            new Disease("Genital herpes","spots or red bumps in specified area, fever","no known cure"),
            new Disease("Genital warts","lumps in specified area","Cream or liquid treatment"),
            new Disease("Gout","joint pain, swelling around joint","ice pack treatment"),
            new Disease("Haemorrhoids","post excretion bleeding, itchy bottom","banding, surgery"),
            new Disease("Hay fever","sneezy, runny nose, itchy eyes","antihistamines"),
            new Disease("Headaches","Headpain","Panadol"),
            new Disease("Heart failure","breathlessness, tiredness","ACE inhibitors, ARBs, betablockers"),
            new Disease("Impetigo","fever and swollen glands, appearance of red sores(usually around the nose and mouth)","antibiotic creams or antibiotic tablets"),
            new Disease("Indigestion","feeling full or bloated, feeling sick (nausea), belching","treat indigestion with a number of different medications, such as antacids."),
            new Disease("Inherited heart conditions","palpitations, fainting or blackouts","implantable cardioverter defibrillators (ICDs), heart transplantation (in rare cases)"),
            new Disease("Insomnia","You may find it difficult to fall asleep, not feel refreshed when you get up","relax before bed time, In some cases, CBT Therapy may be recommended"),
            new Disease("Kidney cancer","blood in urine, constant pain below the ribs","radiotherapy or targeted therapies"),
            new Disease("Kidney stones","evere pain in the abdomen or groin","Larger stones may need to be broken up using ultrasound or laser energy. Occasionally, keyhole surgery may be needed"),
            new Disease("Labyrinthitis","humming in your ear(s), ear pain","vestibular rehabilitation therapy (VRT)"),
            new Disease("Liver disease","loss of appetite, weight loss and jaundice","take the appropriate measures to prevent getting hepatitis, such as getting vaccinated if you're at risk"),
            new Disease("Malaria","Fever, headache, vomiting, muscle pain","Antimalarial medication is used to both treat and prevent malaria"),
            new Disease("Mouth ulcer","round or oval sores on cheecks, lips, tongue","Antimicrobial mouthwash, Corticosteroid lozenges"),
            new Disease("Nasal and sinus cancer","persistent blocked nose, nosebleeds","radiotherapy and chemotherapy"),
            new Disease("Nosebleed","blood flows from one or both nostrils","avoid picking your nose and keep your fingernails short"),
            new Disease("Oral thrush","white patches (plaques) in the mouth, loss of taste","antifungal medicines"),
            new Disease("Osteoarthritis","pain and stiffness in the joints","can't be cured, but symptoms can be reduced"),
            new Disease("Pancreatic cancer","pain in the back or stomach area,unexpected weight loss","surgery,chemotherapy,radiotherapy"),
            new Disease("Pneumonia","rapid heartbeat,sweating and shivering","getting plenty of rest,taking antibiotics,drinking plenty of fluids"),
            new Disease("Rare tumours","consultation with a doctor","surgery,radiotherapy,chemotherapy"),
            new Disease("Reactive arthritis","joints and tendons,urinary system,eyes","Self-care,Antibiotics"),
            new Disease("Schizophrenia","represent a change in behaviour,lack of function ","consultation with psychiatrist"),
            new Disease("Stomach ulcer","Tummy pain,loss of appetite","Antibiotics, a proton pump inhibitor (PPI)"),
            new Disease("Thyroid cancer"," lump or swelling , sore throat","oncologist"),
            new Disease("Tonsillitis","high temperature,feeling sick ","Self-help,Antibiotics"),
            new Disease("Urinary incontinence","pass urine unintentionally","consultation with doctor"),
            new Disease("Ulcerative colitis","recurring diarrhoea,abdominal pain","Aminosalicylates"),
            new Disease("Vertigo","loss of balance ,dizziness ","Labyrinthitis,Vestibular neuronitis"),
            new Disease("Vulval cancer"," persistent itch in the vulva,open sore ","consultation with specialist"),
            new Disease("Whooping cough","gasping for breathing","Vaccinations,disposal of used stuff"),
            new Disease("Yellow fever","viral infection,nausea or vomiting","vaccination")
            
            
            
    );

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.setCellValueFactory(new PropertyValueFactory<Disease,String>("name"));
        symp.setCellValueFactory(new PropertyValueFactory<Disease,String>("symp"));
        treat.setCellValueFactory(new PropertyValueFactory<Disease,String>("treat"));
        
         table.setItems(list);
    }    
    
    
    
}
