<template>
  <div class="hr-job-ui">
    <!-- 上半部分：查询条件 -->
    <div class="search-section">
      <div class="search-row">
        <label>
          <span>候选人姓名：</span>
          <input v-model="candidateName" placeholder="请输入候选人姓名" />
        </label>
      </div>
      <div class="search-row">
        <label>
          <span>毕业学校：</span>
          <input v-model="school" placeholder="请输入毕业学校" />
        </label>
      </div>
      <div class="search-row">
        <label>
          <span>录入时间范围：</span>
          <div class="date-range">
            <input v-model="startDate" type="date" placeholder="开始日期" />
            <span class="date-separator">至</span>
            <input v-model="endDate" type="date" placeholder="结束日期" />
          </div>
        </label>
      </div>
      <div class="search-row">
        <label>
          <span></span>
          <div class="button-group">
            <button @click="searchCandidates">查询</button>
            <button @click="clearSearchFields" class="clear-button">清空</button>
          </div>
        </label>
      </div>
    </div>

    <!-- 下半部分：候选人列表 -->
    <table class="candidate-list">
      <thead>
        <tr>
          <th>序号</th>
          <th>候选人姓名</th>
          <th>候选人年龄</th>
          <th>毕业学校</th>
          <th>社保时间</th>
          <th>录入时间</th>
          <th>专业</th>
          <th>面试进度状态</th>
          <th>面试官</th>
          <th>面试官评论</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(candidate, index) in candidates" :key="index">
          <td>{{ index + 1 }}</td>
          <td>{{ candidate.name }}</td>
          <td>{{ candidate.age }}</td>
          <td>{{ candidate.school }}</td>
          <td>{{ candidate.socialSecurityTime }}</td>
          <td>{{ candidate.entryDate }}</td>
          <td>{{ candidate.major }}</td>
          <td>{{ candidate.interviewStatus }}</td>
          <td>{{ candidate.interviewer }}</td>
          <td>{{ candidate.interviewerComments }}</td>
          <td class="operations">
            <button @click="viewDetails(candidate)">详情</button>
            <button @click="updateCandidate(candidate)">更新</button>
            <button @click="deleteCandidate(candidate)" class="delete-btn">删除</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script setup>
import { ref } from 'vue';

const candidateName = ref('');
const school = ref('');
const startDate = ref('');
const endDate = ref('');
const candidates = ref([]);

const searchCandidates = () => {
  // 实现查询逻辑
  console.log('Querying candidates...');
  console.log('Name:', candidateName.value);
  console.log('School:', school.value);
  console.log('Date range:', startDate.value, 'to', endDate.value);
  // 这里应该调用API或更新candidates数组
};

const clearSearchFields = () => {
  candidateName.value = '';
  school.value = '';
  startDate.value = '';
  endDate.value = '';
};

const viewDetails = (candidate) => {
  console.log('Viewing details for:', candidate.name);
  // 实现查看详情的逻辑
};

const updateCandidate = (candidate) => {
  console.log('Updating candidate:', candidate.name);
  // 实现更新候选人的逻辑
};

const deleteCandidate = (candidate) => {
  console.log('Deleting candidate:', candidate.name);
  // 实现逻辑删除的逻辑
};
</script>

<style scoped>
.hr-job-ui {
  display: flex;
  flex-direction: column;
  padding: 20px;
}

.search-section {
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  gap: 15px;
  max-width: 600px; /* 限制整个搜索区域的最大宽度 */
}

.search-row {
  display: flex;
  align-items: center;
}

.search-section label {
  display: flex;
  align-items: center;
  width: 100%;
}

.search-section label > span {
  min-width: 120px; /* 增加标签宽度以确保对齐 */
  text-align: right;
  margin-right: 10px;
}

.search-section input {
  width: 300px; /* 修改这里，使其与日期范围控件宽度一致 */
  padding: 5px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.date-range {
  display: flex;
  align-items: center;
  width: 300px; /* 固定日期范围整体宽度 */
}

.date-range input {
  width: 130px; /* 固定日期输入框宽度 */
}

.date-separator {
  margin: 0 5px;
}

.button-group {
  display: flex;
  gap: 10px;
  margin-left: 130px; /* 与输入框对齐 */
}

.search-section button {
  padding: 5px 15px;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 80px; /* 固定按钮宽度 */
}

.search-section button:first-child {
  background-color: #4CAF50;
}

.search-section button:first-child:hover {
  background-color: #45a049;
}

.clear-button {
  background-color: #f44336;
}

.clear-button:hover {
  background-color: #d32f2f;
}

.candidate-list {
  width: 100%;
  border-collapse: collapse;
}

.candidate-list th, .candidate-list td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.candidate-list th {
  background-color: #f2f2f2;
}

.operations {
  display: flex;
  gap: 5px;
}

.operations button {
  padding: 2px 5px;
  font-size: 12px;
  cursor: pointer;
  border: none;
  border-radius: 3px;
  color: white;
}

.operations button:first-child {
  background-color: #4CAF50;
}

.operations button:nth-child(2) {
  background-color: #2196F3;
}

.delete-btn {
  background-color: #f44336;
}

.operations button:hover {
  opacity: 0.8;
}
</style>
