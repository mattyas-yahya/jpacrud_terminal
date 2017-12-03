/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobajpa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "work_order", catalog = "bi", schema = "")
@NamedQueries({
    @NamedQuery(name = "WorkOrder.findAll", query = "SELECT w FROM WorkOrder w")
    , @NamedQuery(name = "WorkOrder.findByIdwo", query = "SELECT w FROM WorkOrder w WHERE w.idwo = :idwo")
    , @NamedQuery(name = "WorkOrder.findByProblem", query = "SELECT w FROM WorkOrder w WHERE w.problem = :problem")
    , @NamedQuery(name = "WorkOrder.findByStatus", query = "SELECT w FROM WorkOrder w WHERE w.status = :status")
    , @NamedQuery(name = "WorkOrder.findByScheduleStart", query = "SELECT w FROM WorkOrder w WHERE w.scheduleStart = :scheduleStart")
    , @NamedQuery(name = "WorkOrder.findByNote", query = "SELECT w FROM WorkOrder w WHERE w.note = :note")
    , @NamedQuery(name = "WorkOrder.findByIdtpm", query = "SELECT w FROM WorkOrder w WHERE w.idtpm = :idtpm")})
public class WorkOrder implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idwo")
    private Integer idwo;
    @Column(name = "problem")
    private String problem;
    @Column(name = "status")
    private String status;
    @Column(name = "schedule_start")
    private String scheduleStart;
    @Column(name = "note")
    private String note;
    @Column(name = "idtpm")
    private Integer idtpm;

    public WorkOrder() {
    }

    public WorkOrder(Integer idwo) {
        this.idwo = idwo;
    }

    public Integer getIdwo() {
        return idwo;
    }

    public void setIdwo(Integer idwo) {
        Integer oldIdwo = this.idwo;
        this.idwo = idwo;
        changeSupport.firePropertyChange("idwo", oldIdwo, idwo);
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        String oldProblem = this.problem;
        this.problem = problem;
        changeSupport.firePropertyChange("problem", oldProblem, problem);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(String scheduleStart) {
        String oldScheduleStart = this.scheduleStart;
        this.scheduleStart = scheduleStart;
        changeSupport.firePropertyChange("scheduleStart", oldScheduleStart, scheduleStart);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        String oldNote = this.note;
        this.note = note;
        changeSupport.firePropertyChange("note", oldNote, note);
    }

    public Integer getIdtpm() {
        return idtpm;
    }

    public void setIdtpm(Integer idtpm) {
        Integer oldIdtpm = this.idtpm;
        this.idtpm = idtpm;
        changeSupport.firePropertyChange("idtpm", oldIdtpm, idtpm);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idwo != null ? idwo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkOrder)) {
            return false;
        }
        WorkOrder other = (WorkOrder) object;
        if ((this.idwo == null && other.idwo != null) || (this.idwo != null && !this.idwo.equals(other.idwo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cobajpa.WorkOrder[ idwo=" + idwo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
