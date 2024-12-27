package pj.spring.vo;

import lombok.Data;

@Data
public class KakaoPayResponse { // API ���� ������

    private String tid;                  // ���� ������ȣ
    private String next_redirect_pc_url; // īī�������� ���� ��û �޽���(TMS)�� ������ ���� ����� ���� �Է�ȭ�� Redirect URL (īī�� �� ����)
    private String created_at; // ���� ���� �ð�
	
    public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
    
    
}
