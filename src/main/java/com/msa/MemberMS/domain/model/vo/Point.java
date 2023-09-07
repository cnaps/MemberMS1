package com.msa.MemberMS.domain.model.vo;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    public Long pointValue ;

    public Long addPoint(Long point){
        this.pointValue = this.pointValue + point;
        return pointValue;
    }

    public Long removePoint(Long point) throws Exception {
        if(point > this.pointValue) {
            throw new Exception("기존 보유 Point보다 적어 삭제할 수 없습니다.");
        }
        this.pointValue = this.pointValue -point;
        return pointValue;
    }

    public static Point sample(){
        return new Point(10L);
    }

    public static Point cratePoint(){
        return new Point(0L);
    }
}

