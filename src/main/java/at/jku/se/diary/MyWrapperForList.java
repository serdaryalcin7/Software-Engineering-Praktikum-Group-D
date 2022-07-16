package at.jku.se.diary;

import javafx.collections.ObservableList;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 *
 * @author Marco Jakob
 */
@XmlRootElement
public class MyWrapperForList {

    ObservableList<DiaryEntry> diaryEntries;

    @XmlElement
    public ObservableList<DiaryEntry> getDiaryEntries() {
        return diaryEntries;
    }

    public void setDiaryEntries(ObservableList<DiaryEntry> diaryEntries) {
        this.diaryEntries = diaryEntries;
    }
}